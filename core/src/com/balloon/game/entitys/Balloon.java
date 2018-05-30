package com.balloon.game.entitys;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.balloon.game.BodyBuilder;
import com.balloon.game.Constants;
import com.balloon.game.PlayerInputListener;

import java.util.HashMap;
import java.util.Map;

public class Balloon extends Entity {
    public Balloon(World world) {
        super();
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setScale(SCALE_X, SCALE_Y);
        setRotation(ROTATION);
        setOrigin(WIDTH /2.0f, HEIGHT /2.0f);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(getWidth()/2f);

        body = new BodyBuilder()
                .withType(BodyDef.BodyType.DynamicBody)
                .withWorld(world)
                .withUserData(this)
                .withDensity(DENSITY)
                .withFriction(FRICTION)
                .withRestitution(RESTITUTION)
                .withShape(circleShape)
                .build();

        circleShape.dispose();
        this.addListener(new PlayerInputListener(this));
        forces = new HashMap<Integer, Vector2>();
    }

    @Override
    public void act(float delta) {
        /* TODO why does going up reduce x speed? */
        /* TODO ^ density affects this */

        if(touched)
            body.applyForceToCenter(body.getLinearVelocity().x, body.getLinearVelocity().y + IMPULSE, true);

        if(getIsBlown())
            body.applyForceToCenter(getBlowForceX(), getBlowForceY(), true);

        if(body.getLinearVelocity().x > MAX_X_SPEED)
            body.setLinearVelocity(MAX_X_SPEED, body.getLinearVelocity().y);

    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return this;
    }

    @Override
    public float getRotation() {
        return body.getLinearVelocity().x * -1 / SWAY;
    }

    public void blow(float rotation, float force, int windId) {
        float angle = rotationToAngleOfForce(rotation);
        float angleInRadians = angle * Constants.DEGREES_TO_RADIANS;

        float thisBlowForceX = (float) Math.cos(angleInRadians) * force * rotationToXDirection(rotation);
        float thisBlowForceY = (float) Math.sin(angleInRadians) * force * rotationToYDirection(rotation);
        setBlowForceX(getBlowForceX() + thisBlowForceX);
        setBlowForceY(getBlowForceY() + thisBlowForceY);

        forces.put(windId, new Vector2(thisBlowForceX, thisBlowForceY));
    }

    private int rotationToXDirection(float rotation) {
        if(rotation <= 90) {
            return 1;
        }

        if(rotation <= 180) {
            return -1;
        }

        if(rotation <= 270) {
            return -1;
        }

        return 1;
    }

    private int rotationToYDirection(float rotation) {
        if(rotation <= 90) {
            return 1;
        }

        if(rotation <= 180) {
            return 1;
        }

        if(rotation <= 270) {
            return -1;
        }

        return -1;
    }

    private float rotationToAngleOfForce(float rotation) {
        if(rotation <= 90) {
            return rotation;
        }

        if(rotation <= 180) {
            return 180 - rotation;
        }

        if(rotation <= 270) {
            return rotation - 180;
        }

        return 360 - rotation;
    }

    public void stopBlow(int windId) {
        Vector2 thisWind = forces.get(windId);
        setBlowForceX(getBlowForceX() - thisWind.x);
        setBlowForceY(getBlowForceY() - thisWind.y);
        forces.remove(windId);
    }

    public boolean touchDown() {
        return touched = true;
    }

    public void touchUp() {
        touched = false;
    }

    public boolean getIsBlown() {
        return !forces.isEmpty();
    }

    public void setBlowForceX(float force) {
        this.blowForceX = force;
    }

    public float getBlowForceX() {
        return blowForceX;
    }

    public void setBlowForceY(float force) {
        this.blowForceY = force;
    }

    public float getBlowForceY() {
        return blowForceY;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(textureRegion, getX() - getOriginX(), getY() - getOriginY() - Y_OFFSET, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Builder withWorld(World world) {
            this.world = world;
            return this;
        }

        public Balloon build() {
            Balloon construct = new Balloon(world);
            return construct;
        }

        private World world;
    }

    private boolean touched = false;

    private float blowForceX;
    private float blowForceY;
    Map<Integer, Vector2> forces;

    private final float MAX_X_SPEED = 90;
    private final int SWAY = 5; /* higher is less sway */

    private final float IMPULSE = 8000;
    private final float DENSITY = 0.02f;
    private final float RESTITUTION = 0.15f;
    private final float FRICTION = 0.2f;

    private final int WIDTH = 25;
    private final int HEIGHT = 30;

    private final int Y_OFFSET = 2;

    private final int SCALE_X = 1;
    private final int SCALE_Y = 1;
    private final int ROTATION = 0;

    private CircleShape shape;
    private BodyDef bodyDef;

    private final String IMG_PATH = "img/balloon.png";
    private final Texture texture = new Texture(IMG_PATH);
    private final TextureRegion textureRegion = new TextureRegion(texture);
}

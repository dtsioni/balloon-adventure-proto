package com.balloon.game.entitys;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.BodyBuilder;
import com.balloon.game.Constants;

public class Wall extends Entity {
    public Wall(World world) {
        super();
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setScale(SCALE_X, SCALE_Y);
        setOrigin(WIDTH /2.0f, HEIGHT /2.0f);

        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(WIDTH / 2f, HEIGHT / 2f);

        body = new BodyBuilder()
                .withType(BodyDef.BodyType.StaticBody)
                .withWorld(world)
                .withUserData(this)
                .withDensity(DENSITY)
                .withFriction(FRICTION)
                .withRestitution(RESTITUTION)
                .withShape(polygonShape)
                .build();

        polygonShape.dispose();
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(textureRegion, getX() - getOriginX(), getY() - getOriginY() - Y_OFFSET, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void setRotation(float degrees) {
        super.setRotation(degrees);
        getBody().setTransform(getBody().getPosition(), degrees * Constants.DEGREES_TO_RADIANS);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Builder withRotation(float r) {
            this.rotation = r;
            return this;
        }

        public Builder withWorld(World world) {
            this.world = world;
            return this;
        }

        public Wall build() {
            Wall construct = new Wall(world);
            construct.setRotation(rotation);
            return construct;
        }

        private World world;
        private float rotation = 0;
    }

    private final float DENSITY = 8f;
    private final float RESTITUTION = 0.05f;
    private final float FRICTION = 0.08f;

    private final int HEIGHT = 2;
    private final int WIDTH = Constants.GRID_SIZE + HEIGHT;

    private final int Y_OFFSET = 0;

    private final int SCALE_X = 1;
    private final int SCALE_Y = 1;

    private final String IMG_PATH = "img/wall.jpg";
    private final Texture texture = new Texture(IMG_PATH);
    private final TextureRegion textureRegion = new TextureRegion(texture);
}

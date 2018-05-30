package com.balloon.game.entitys;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.BodyBuilder;
import com.balloon.game.Constants;

public class Wind extends Entity {
    public Wind(World world) {
        super();
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setScale(SCALE_X, SCALE_Y);
        setOrigin(WIDTH /2.0f, HEIGHT /2.0f);

        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(WIDTH / 2f, HEIGHT / 2f);

        body = new BodyBuilder()
                .withType(BodyDef.BodyType.StaticBody)
                .withUserData(this)
                .withWorld(world)
                .withShape(polygonShape)
                .withIsSensor(true)
                .build();

        polygonShape.dispose();
    }

    @Override
    public void rotationChanged() {
        body.setTransform(body.getPosition(), getRotation() * Constants.DEGREES_TO_RADIANS);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(textureRegion, getX() - getOriginX(), getY() - getOriginY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public float getForce() {
        return force;
    }

    public void setForce(float f) {
        this.force = f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Builder withRotation(float r) {
            this.rotation = r;
            return this;
        }

        public Builder withForce(float f) {
            this.force = f;
            return this;
        }

        public Builder withWorld(World w) {
            this.world = w;
            return this;
        }

        public Builder withXY(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Wind build() {
            Wind construct = new Wind(world);
            construct.setForce(force);
            construct.setRotation(rotation);
            return construct;
        }

        private float rotation = 0;
        private float force;
        private World world;
        private int x = 0;
        private int y = 0;
    }

    private float force;

    private final int WIDTH = Constants.GRID_SIZE - 5;
    private final int HEIGHT = WIDTH;

    private final int SCALE_X = 1;
    private final int SCALE_Y = 1;

    private final String IMG_PATH = "img/arrows.png";
    private final Texture texture = new Texture(IMG_PATH);
    private final TextureRegion textureRegion = new TextureRegion(texture);
}

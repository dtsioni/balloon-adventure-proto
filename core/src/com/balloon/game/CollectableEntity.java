package com.balloon.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.Entity;
import com.balloon.game.handlers.RemoveBodyHandler;

public abstract class CollectableEntity extends Entity {
    public CollectableEntity(World world) {
        super();
        setHeight(getThisHeight());
        setWidth(getThisWidth());
        setScale(SCALE_X, SCALE_Y);
        setOrigin(getThisWidth() / 2.0f, getThisHeight() / 2.0f);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(getWidth()/getShapeCollisionRatio());

        body = new BodyBuilder()
                .withType(BodyDef.BodyType.StaticBody)
                .withUserData(this)
                .withWorld(world)
                .withShape(circleShape)
                .withIsSensor(true)
                .build();

        circleShape.dispose();

        IMG_PATH = getImagePath();
        texture = new Texture(IMG_PATH);
        textureRegion = new TextureRegion(texture);
    }

    public boolean collect() {
        RemoveBodyHandler.addBody(body);
        this.remove();
        return internalCollect();
    }

    protected int getThisWidth() {
        return WIDTH;
    }

    protected int getThisHeight() {
        return HEIGHT;
    }

    protected float getShapeCollisionRatio() {
        return SHAPE_COLLISION_RATIO;
    }

    protected abstract boolean internalCollect();

    public abstract String getImagePath();

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(textureRegion, getX() - getOriginX(), getY() - getOriginY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    private final int WIDTH = Constants.GRID_SIZE / 2;
    private final int HEIGHT = WIDTH;
    private final float SHAPE_COLLISION_RATIO = 3f;

    private final int SCALE_X = 1;
    private final int SCALE_Y = 1;

    private final String IMG_PATH;
    private final Texture texture;
    private final TextureRegion textureRegion;
}

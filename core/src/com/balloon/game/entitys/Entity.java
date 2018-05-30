package com.balloon.game.entitys;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {
    public Body getBody() {
        return body;
    }

    @Override
    public float getX() {
        return getBody().getPosition().x;
    }

    @Override
    public float getY() {
        return getBody().getPosition().y;
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int) getX();
        result = 31 * result + (int) getY();
        result = 31 * result + (int) getRotation();
        return result;
    }

    protected Body body;
}

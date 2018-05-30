package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level1 extends Level {
    public Level1() {
        addEntityOnGrid(starFactory.star(), 0, 1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, -1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 1, 2);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 3);
        addEntityOnGrid(balloonFactory.balloon(), 0, 0);
    }

    public Vector2 getCameraPosition() {
        return CAMERA_POSITION;
    }

    public float getCameraZoom() {
        return CAMERA_ZOOM;
    }

    public int getNumberOfStars() {
        return STARS;
    }

    private final Vector2 CAMERA_POSITION = new Vector2(0, 20);
    private final float CAMERA_ZOOM = 0.15f;
    private final int STARS = 1;
}

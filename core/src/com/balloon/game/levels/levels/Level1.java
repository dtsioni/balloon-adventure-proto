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


        addEntityOnGrid(balloon, 0, 0);
    }

    public Vector2 getCameraPosition() {
        return CAMERA_POSITION;
    }

    public float getCameraZoom() {
        return CAMERA_ZOOM;
    }

    public int getWorldWidth() {
        return WORLD_WIDTH;
    }

    public int getNumberOfStars() {
        return STARS;
    }

    private final int WORLD_WIDTH = GRID_SIZE + MARGIN;
    private final Vector2 CAMERA_POSITION = new Vector2(0, 0.5f * GRID_SIZE);
    private final float CAMERA_ZOOM = 1f;
    private final int STARS = 1;
}

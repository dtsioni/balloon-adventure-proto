package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level4 extends Level {
    public Level4() {
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 6);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, 6);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 4, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 4, 6);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 6, -1);

        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 3);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 6, 3);

        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 5);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 7, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 7, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 5, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 5, 5);

        addEntityOnHalfGrid(mineFactory.mine(), 3, 0);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 2);

        addEntityOnGrid(windFactory.windRight(), 0, 1);
        addEntityOnGrid(windFactory.windLeft(), 3, 1);

        addEntityOnGrid(starFactory.star(), 0, 2);
        /* TODO this is broken */
        addEntity(starFactory.silverStar(), 22, 17);

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

    public int getWorldWidth() {
        return WORLD_WIDTH;
    }

    private final Vector2 CAMERA_POSITION = new Vector2(1.5f *GRID_SIZE, 1.5f * GRID_SIZE);
    private final float CAMERA_ZOOM = 1f;
    private final int STARS = 1;
    private final int WORLD_WIDTH = GRID_SIZE * 4 + MARGIN;
}

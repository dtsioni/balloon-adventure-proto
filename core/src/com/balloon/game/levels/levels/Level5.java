package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level5 extends Level {
    public Level5() {
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 0);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 9);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, -2);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, 9);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 1, -1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 6);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 8);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, -1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 6);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 8);

        addEntityOnHalfGrid(windFactory.windLeft(), 2, 1);
        addEntityOnHalfGrid(windFactory.windLeft(), 2, 5);
        addEntityOnHalfGrid(windFactory.windRight(), 0, 3);
        addEntityOnHalfGrid(windFactory.windRight(), 0, 7);

        addEntityOnHalfGrid(mineFactory.mine(), 0, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 2, 3);
        addEntityOnHalfGrid(mineFactory.mine(), 2, 7);
        addEntityOnHalfGrid(mineFactory.mine(), 0, 5);

        addEntityOnGrid(starFactory.star(), 1, 4);

        addEntityOnHalfGrid(balloon, 2, -1);
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

    private final Vector2 CAMERA_POSITION = new Vector2(0.5f * GRID_SIZE, 1.5f * GRID_SIZE);
    private final float CAMERA_ZOOM = 1f;
    private final int STARS = 1;
    private final int WORLD_WIDTH = (int) (GRID_SIZE * 3.5) + MARGIN;
}

package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.Constants;
import com.balloon.game.levels.Level;

public class Level3 extends Level {
    public Level3() {
        addEntityOnGrid(windFactory.windRight(), 0, 1);
        addEntityOnGrid(windFactory.windRight(), 1, 1);
        addEntityOnGrid(windFactory.windLeft(), 1, 3);

        addEntityOnGrid(starFactory.star(), 0, 3);

        addEntityOnGrid(mineFactory.mine(), 0, 2);
        addEntityOnHalfGrid(mineFactory.mine(), 1, 4);

        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, 1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 6);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 3, 6);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 7);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, 7);

        addEntityOnGrid(balloonFactory.balloon(), 0, 0);
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

    private final Vector2 CAMERA_POSITION = new Vector2(0.5f * GRID_SIZE, 1.5f * GRID_SIZE);
    private final float CAMERA_ZOOM = 1f;
    private final int STARS = 1;
    private final int WORLD_WIDTH = GRID_SIZE * 4 + MARGIN;
}

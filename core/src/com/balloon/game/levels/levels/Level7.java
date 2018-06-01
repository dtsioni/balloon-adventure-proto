package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level7 extends Level {
    public Level7() {
        createRoom(8, 6);

        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 3);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 1, 3);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(),  8, 5);

        addEntityOnHalfGrid(mineFactory.mine(), 3, 6);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 4);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 3);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 2);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 0);

        addEntityOnHalfGrid(mineFactory.mine(), 6, 5);
        addEntityOnHalfGrid(mineFactory.mine(), 6, 4);
        addEntityOnHalfGrid(mineFactory.mine(), 6, 3);
        addEntityOnHalfGrid(mineFactory.mine(), 6, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 6, 0);

        addEntityOnGrid(windFactory.windRight(), 0, 3);
        addEntityOnGrid(windFactory.windLeft(), 4, 3);
        addEntityOnGrid(windFactory.windLeft(), 4, 1);

        addEntityOnGrid(starFactory.star(), 0, 0);
        addEntityOnGrid(starFactory.silverStar(), 4, 3);

        addEntityOnGrid(balloonFactory.balloon(), 0, 2);

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

    private final Vector2 CAMERA_POSITION = new Vector2(2f * GRID_SIZE, 1.5f * GRID_SIZE);
    private final float CAMERA_ZOOM = 1f;
    private final int STARS = 1;
    private final int WORLD_WIDTH = GRID_SIZE * 5 + MARGIN;
}

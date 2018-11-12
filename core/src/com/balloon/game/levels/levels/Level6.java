package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level6 extends Level {
    public Level6() {
        addWallsLine(0, 0, 0, 6, -1, 0);
        addWallsLine(0, 6, 8, 6, 0, 1);
        addWallsLine(8, 2, 8, 6, 1, 0);
        //addWallsLine(2, 1, 4, 1, 0, 0);

        addEntityOnGrid(windFactory.windRight(), 0, 1);
        addEntityOnGrid(windFactory.windRight(), 3, 3);
        addEntityOnGrid(windFactory.windLeft(), 1, 3);
        addEntityOnGrid(windFactory.windLeft(), 4, 1);
        addEntityOnGrid(windFactory.windLeft(), 3, 1);

        addEntityOnHalfGrid(mineFactory.mine(), 2, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 4, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 5, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 6, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 7, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 8, 1);


        addEntityOnGrid(mineFactory.mine(), 0, 2);
        addEntityOnGrid(mineFactory.mine(), 1, 2);
        addEntityOnGrid(mineFactory.mine(), 3, 2);
        addEntityOnHalfGrid(mineFactory.mine(), 1, 4);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 4);
        addEntityOnHalfGrid(mineFactory.mine(), 5, 4);
        addEntityOnHalfGrid(mineFactory.mine(), 7, 4);

        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, -1);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 1, 0);

        addEntityOnGrid(starFactory.star(), 0, 3);
        addEntityOnGrid(starFactory.silverStar(), 4, 3);

        addEntityOnGrid(balloon, 0, 0);
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
    private final float CAMERA_ZOOM = 0.5f;
    private final int STARS = 1;
    private final int WORLD_WIDTH = GRID_SIZE * 5 + MARGIN;
}

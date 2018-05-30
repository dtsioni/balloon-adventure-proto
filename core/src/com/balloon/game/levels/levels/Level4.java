package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level4 extends Level {
    public Level4() {
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 7);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 2, 7);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 4, -1);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 4, 7);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 6, -1);

        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 0, 3);
        addEntityOnHalfGrid(wallFactory.wallHorizontal(), 6, 3);

        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), -1, 6);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 7, 0);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 7, 2);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 5, 4);
        addEntityOnHalfGrid(wallFactory.wallVertical(), 5, 6);

        addEntityOnHalfGrid(mineFactory.mine(), 3, 0);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 1);
        addEntityOnHalfGrid(mineFactory.mine(), 3, 2);

        addEntityOnGrid(windFactory.windRight(), 0, 1);
        addEntityOnGrid(windFactory.windLeft(), 3, 1);

        addEntityOnGrid(starFactory.star(), 0, 2);
        addEntityOnHalfGrid(silverStarFactory.star(), 3, 6);

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

    private final Vector2 CAMERA_POSITION = new Vector2(70, 70);
    private final float CAMERA_ZOOM = 0.3f;
    private final int STARS = 1;
}

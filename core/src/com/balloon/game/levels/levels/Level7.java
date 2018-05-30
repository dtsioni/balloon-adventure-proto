package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level7 extends Level {
    public Level7() {
        createRoom(8, 6);

        addEntityOnGrid(windFactory.windRight(), 0, 3);
        addEntityOnGrid(windFactory.windLeft(), 4, 1);

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

    private final Vector2 CAMERA_POSITION = new Vector2(100, 80);
    private final float CAMERA_ZOOM = 0.3f;
    private final int STARS = 1;
}

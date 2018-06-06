package com.balloon.game.levels.levels;

import com.badlogic.gdx.math.Vector2;
import com.balloon.game.levels.Level;

public class Level8 extends Level {
    public Level8() {
        createRoom(6, 4);
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

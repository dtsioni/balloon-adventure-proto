package com.balloon.game.levels;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.balloon.game.levels.levels.*;

import java.util.List;

public class LevelLoader {
    public World getWorld() {
        return level.getWorld();
    }

    public List<Actor> getActors() {
        return level.getActors();
    }

    public void withLevel(int n) {
        prevLevel = n;
        switch(n) {
            case 1:
                this.level = new Level1();
                return;
            case 2:
                this.level = new Level2();
                return;
            case 3:
                this.level = new Level3();
                return;
            case 4:
                this.level = new Level4();
                return;
            case 5:
                this.level = new Level5();
                return;
            case 6:
                this.level = new Level6();
                return;
            case 7:
                this.level = new Level7();
                return;
            case 8:
                this.level = new Level8();
                return;
            default:
                withLevel(prevLevel - 1);
                return;
        }
    }

    public int getLevelScore() {
        return level.getNumberOfStars();
    }

    public Vector2 getCameraPosition() {
        return level.getCameraPosition();
    }

    public float getCameraZoom() {
        return level.getCameraZoom();
    }

    public int getWorldWidth() {
        return level.getWorldWidth();
    }

    private int prevLevel;
    private Level level;
}

package com.balloon.game.entitys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.CollectableEntity;
import com.balloon.game.handlers.MineHandler;

public class Mine extends CollectableEntity {
    public Mine(World world) {
        super(world);
    }

    @Override
    public boolean internalCollect() {
        MineHandler.mineExploded();
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Builder withWorld(World w) {
            this.world = w;
            return this;
        }

        public Mine build() {
            Mine construct = new Mine(world);
            return construct;
        }

        private World world;
    }

    @Override
    public String getImagePath() {
        return IMG_PATH;
    }

    private final String IMG_PATH = "img/mine.png";
}

package com.balloon.game.entitys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.CollectableEntity;
import com.balloon.game.handlers.StarHandler;

public class Star extends CollectableEntity {
    public Star(World world) {
        super(world);
    }

    @Override
    public boolean internalCollect() {
        StarHandler.goldStarCollected();
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

        public Star build() {
            Star construct = new Star(world);
            return construct;
        }

        private World world;
    }

    @Override
    public String getImagePath() {
        return IMG_PATH;
    }

    private final String IMG_PATH = "img/goldStar.png";
}

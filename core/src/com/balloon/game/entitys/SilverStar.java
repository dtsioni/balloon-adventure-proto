package com.balloon.game.entitys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.CollectableEntity;
import com.balloon.game.Constants;
import com.balloon.game.handlers.StarHandler;

public class SilverStar extends CollectableEntity {
    public SilverStar(World world) {
        super(world);
    }

    @Override
    public boolean internalCollect() {
        StarHandler.silverStarCollected();
        return false;
    }

    @Override
    public String getImagePath() {
        return IMG_PATH;
    }

    @Override
    protected float getShapeCollisionRatio() {
        return 2f;
    }

    @Override
    protected int getThisWidth() {
        return Constants.GRID_SIZE / 3;
    }

    @Override
    protected int getThisHeight() {
        return Constants.GRID_SIZE / 3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Builder withWorld(World w) {
            this.world = w;
            return this;
        }

        public SilverStar build() {
            SilverStar construct = new SilverStar(world);
            return construct;
        }

        private World world;
    }

    private final String IMG_PATH = "img/silverStar.png";
}

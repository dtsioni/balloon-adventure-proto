package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.SilverStar;

public class SilverStarFactory {
    public SilverStarFactory(World world) {
        this.world = world;
    }

    public SilverStar star() {
        return SilverStar.builder()
                .withWorld(world)
                .build();
    }

    private World world;
}

package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.Mine;

public class MineFactory {
    public MineFactory(World world) {
        this.world = world;
    }

    public Mine mine() {
        return Mine.builder()
                .withWorld(world)
                .build();
    }

    private World world;
}

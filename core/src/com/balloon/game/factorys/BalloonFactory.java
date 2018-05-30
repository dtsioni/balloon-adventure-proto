package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.Balloon;

public class BalloonFactory {
    public BalloonFactory(World world) {
        this.world = world;
    }

    public Balloon balloon() {
        return Balloon.builder()
                    .withWorld(world)
                    .build();
    }

    private World world;
}

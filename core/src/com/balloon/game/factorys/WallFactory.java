package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.Wall;

public class WallFactory {
    public WallFactory(World world) {
        this.world = world;
    }

    public Wall wallHorizontal() {
        return Wall.builder()
                .withWorld(world)
                .withRotation(0)
                .build();
    }

    public Wall wallVertical() {
        return Wall.builder()
                .withWorld(world)
                .withRotation(90)
                .build();
    }

    private World world;
}

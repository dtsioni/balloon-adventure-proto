package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.Wind;

public class WindFactory {
    public WindFactory(World world) {
        this.world = world;
    }

    public Wind windLeft() {
        return windRotation(180);
    }

    public Wind windRight() {
        return windRotation(0);
    }

    public Wind windUp() {
        return windRotation(90);
    }

    public Wind windDown() {
        return windRotation(270);
    }

    public Wind windRotation(float rotation) {
        return Wind.builder()
                .withWorld(world)
                .withForce(force)
                .withRotation(rotation)
                .build();
    }

    private World world;
    private float force = 100f;
}

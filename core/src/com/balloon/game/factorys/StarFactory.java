package com.balloon.game.factorys;

import com.badlogic.gdx.physics.box2d.World;
import com.balloon.game.entitys.SilverStar;
import com.balloon.game.entitys.Star;

public class StarFactory {
    public StarFactory(World world) {
        this.world = world;
    }

    public Star star() {
        return Star.builder()
                .withWorld(world)
                .build();
    }

    public SilverStar silverStar() {
        return SilverStar.builder()
                .withWorld(world)
                .build();
    }

    private World world;
}

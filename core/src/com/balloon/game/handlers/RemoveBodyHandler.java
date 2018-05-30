package com.balloon.game.handlers;

import com.badlogic.gdx.physics.box2d.Body;

import java.util.ArrayList;
import java.util.List;

public class RemoveBodyHandler {
    public RemoveBodyHandler() {
        bodys = new ArrayList<Body>();
    }

    public static void removeBodysFromWorld() {
        for(Body body: bodys)
            body.getWorld().destroyBody(body);

        bodys = new ArrayList<Body>();
    }

    public static void addBody(Body body) {
        bodys.add(body);
    }

    private static List<Body> bodys;
}

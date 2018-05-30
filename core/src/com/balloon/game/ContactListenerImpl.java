package com.balloon.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.balloon.game.entitys.Balloon;
import com.balloon.game.entitys.Wind;

public class ContactListenerImpl implements ContactListener {
    @Override
    public void endContact(Contact contact) {
        final Body bodyA = contact.getFixtureA().getBody();
        final Body bodyB = contact.getFixtureB().getBody();

        final Object userDataA = bodyA.getUserData();
        final Object userDataB = bodyB.getUserData();

        if(userDataA == null || userDataB == null) return;

        if(userDataA instanceof Balloon || userDataB instanceof Balloon) {
            if (userDataB instanceof Wind) {
                Gdx.app.debug("End contact", "Wind");
                ((Balloon) userDataA).stopBlow(userDataB.hashCode());
            }

            if (userDataA instanceof Wind) {
                Gdx.app.debug("End contact", "Wind");
                ((Balloon) userDataB).stopBlow(userDataA.hashCode());
            }
        }
    }

    @Override
    public void beginContact(Contact contact) {
        final Body bodyA = contact.getFixtureA().getBody();
        final Body bodyB = contact.getFixtureB().getBody();

        final Object userDataA = bodyA.getUserData();
        final Object userDataB = bodyB.getUserData();

        if(userDataA == null || userDataB == null) return;

        if(userDataA instanceof Balloon || userDataB instanceof Balloon) {
            if (userDataB instanceof Wind) {
                Gdx.app.debug("Begin contact", "Wind");
                Wind objectB = (Wind) userDataB;
                ((Balloon) userDataA).blow(objectB.getRotation(), objectB.getForce(), objectB.hashCode());
            }

            if (userDataA instanceof Wind) {
                Gdx.app.debug("Begin contact", "Wind");
                Wind objectA = (Wind) userDataA;
                ((Balloon) userDataB).blow(objectA.getRotation(), objectA.getForce(), objectA.hashCode());
            }

            if (userDataB instanceof CollectableEntity) {
                if(((CollectableEntity) userDataB).collect()) {

                }
            }

            if (userDataA instanceof CollectableEntity) {
                if(((CollectableEntity) userDataA).collect()) {

                }
            }
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

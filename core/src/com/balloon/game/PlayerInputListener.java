package com.balloon.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.balloon.game.entitys.Balloon;

public class PlayerInputListener extends InputListener {
    public PlayerInputListener(Balloon balloon) {
        this.balloon = balloon;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        return balloon.touchDown();
    }

    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        balloon.touchUp();
    }

    private Balloon balloon;
}

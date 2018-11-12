package com.balloon.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FollowingOrthographicCamera extends OrthographicCamera {
    public FollowingOrthographicCamera(Actor subject, float screenWidth, float screenHeight) {
        super(screenWidth, screenHeight);
        this.subject = subject;
    }

    @Override
    public void update(){
        super.update();
        if(subject != null) {
            position.x = subject.getX();
        }
    }

    private final Actor subject;
}

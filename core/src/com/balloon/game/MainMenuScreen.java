package com.balloon.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
    final HotAirGame hotAirGame;
    OrthographicCamera orthographicCamera;

    public MainMenuScreen(final HotAirGame hotAirGame) {
        this.hotAirGame = hotAirGame;

        orthographicCamera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        orthographicCamera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        orthographicCamera.update();
        hotAirGame.batch.setProjectionMatrix(orthographicCamera.combined);

        hotAirGame.batch.begin();
        hotAirGame.font.draw(hotAirGame.batch, "Welcome to Hot Air Balloon ", SCREEN_WIDTH/2 - 50, SCREEN_HEIGHT/2 - 50);
        hotAirGame.font.draw(hotAirGame.batch, "Tap anywhere to begin!", SCREEN_WIDTH/2 - 50, SCREEN_HEIGHT/2 - 100);
        hotAirGame.batch.end();

        if (Gdx.input.isTouched()) {
            hotAirGame.showLevel(0);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private final static int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final static int SCREEN_HEIGHT = Gdx.graphics.getHeight();
}

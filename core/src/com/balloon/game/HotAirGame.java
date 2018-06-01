package com.balloon.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HotAirGame extends Game {
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		batch = new SpriteBatch();
		font = new BitmapFont();

		showLevel(5);
	}

	public void showMainMenu() {
		if(getScreen() != null) getScreen().hide();
		mainMenuScreen = new MainMenuScreen(this);
		this.setScreen(mainMenuScreen);
	}

	public void showLevel(int level) {
		if(getScreen() != null) getScreen().hide();
		levelScreen = new LevelScreen(this, level);
		this.setScreen(levelScreen);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	private MainMenuScreen mainMenuScreen;
	private LevelScreen levelScreen;
	public SpriteBatch batch;
	public BitmapFont font;
}

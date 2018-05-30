package com.balloon.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.balloon.game.handlers.MineHandler;
import com.balloon.game.handlers.RemoveBodyHandler;
import com.balloon.game.handlers.StarHandler;
import com.balloon.game.levels.LevelLoader;

public class LevelScreen implements Screen {
    public LevelScreen(HotAirGame hotAirGame, int level) {
        this.hotAirGame = hotAirGame;
        this.level = level;
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        batch = new SpriteBatch();
        levelLoader = new LevelLoader();
        stage = new Stage();
        debugRenderer = new Box2DDebugRenderer();
        contactListenerImpl = new ContactListenerImpl();
        removeBodyHandler = new RemoveBodyHandler();
        bitmapFont = new BitmapFont();
        starHandler = new StarHandler();
        inputProcessor = new InputProcessorImpl(stage);
        orthographicCamera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        fitViewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, orthographicCamera);

        orthographicCamera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        stage.setViewport(fitViewport);
        levelLoader.withLevel(level);
        orthographicCamera.position.set(levelLoader.getCameraPosition(), 0);
        orthographicCamera.zoom = levelLoader.getCameraZoom();
        StarHandler.withStars(levelLoader.getLevelScore());
        Gdx.input.setInputProcessor(inputProcessor);
        debugRenderer.setDrawVelocities(true);

        world = levelLoader.getWorld();
        for(Actor actor: levelLoader.getActors())
            stage.addActor(actor);

        world.setContactListener(contactListenerImpl);
    }

    @Override
    public void show() {

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        batch.begin();
        stage.draw();
        batch.end();

        //debugRenderer.render(world, orthographicCamera.combined);
        world.step(1/60f, 6, 2);
        RemoveBodyHandler.removeBodysFromWorld();

        if(Gdx.app.getInput().isKeyPressed(Input.Keys.SPACE)) {
            hotAirGame.showLevel(level + 1);
            resetHandlers();
        }

        if(Gdx.app.getInput().isKeyPressed(Input.Keys.R)) {
            hotAirGame.showLevel(level);
            resetHandlers();
        }

        if(Gdx.app.getInput().isButtonPressed(Input.Keys.BACK)) {
            hotAirGame.showMainMenu();
        }

        if(StarHandler.isAllGoldStarsCollected()) {
            hotAirGame.showLevel(level + 1);
            resetHandlers();
        }

        if(MineHandler.isGameOver()) {
            hotAirGame.showLevel(level);
            resetHandlers();
        }
    }

    private static void resetHandlers() {
        StarHandler.reset();
        MineHandler.reset();
    }

    @Override
    public void resize(int width, int height) {
        fitViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
    public void dispose () {
        batch.dispose();
        world.dispose();
    }

    private final static int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final static int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    private final static int WORLD_WIDTH = SCREEN_WIDTH;
    private final static int WORLD_HEIGHT = SCREEN_HEIGHT;

    private HotAirGame hotAirGame;
    private int level;
    private LevelLoader levelLoader;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera orthographicCamera;
    private Stage stage;
    public SpriteBatch batch;
    public BitmapFont bitmapFont;
    private Viewport fitViewport;
    private InputProcessor inputProcessor;
    private ContactListenerImpl contactListenerImpl;
    private RemoveBodyHandler removeBodyHandler;
    private StarHandler starHandler;
}

package com.balloon.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        ASPECT_RATIO = SCREEN_WIDTH / SCREEN_HEIGHT;

        backgroundTexture = new Texture(BACKGROUND_PATH);
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        batch = new SpriteBatch();
        levelLoader = new LevelLoader();
        debugRenderer = new Box2DDebugRenderer();
        contactListenerImpl = new ContactListenerImpl();
        removeBodyHandler = new RemoveBodyHandler();
        bitmapFont = new BitmapFont();
        starHandler = new StarHandler();
        /* TODO fix this camera bullshit */
        orthographicCamera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);

        orthographicCamera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        levelLoader.withLevel(level);
        fitViewport = new FitViewport(levelLoader.getWorldWidth(), levelLoader.getWorldWidth() / ASPECT_RATIO, orthographicCamera);
        stage = new Stage(fitViewport, batch);
        inputProcessor = new InputProcessorImpl(stage);
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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        batch.begin();
        batch.draw(backgroundTexture, -20, -20);
        batch.end();

        stage.draw();
        //debugRenderer.render(world, orthographicCamera.combined);

        world.step(1/60f, 6, 2);
        RemoveBodyHandler.removeBodysFromWorld();

        if(Gdx.app.getInput().isKeyPressed(Input.Keys.E)) {
            if(level == 6) level = 0;
            hotAirGame.showLevel(level + 1);
            resetHandlers();
        }

        if(Gdx.app.getInput().isKeyPressed(Input.Keys.R)) {
            hotAirGame.showLevel(level);
            resetHandlers();
        }

        if(Gdx.app.getInput().isKeyPressed(Input.Keys.Q)) {
            hotAirGame.showLevel(level - 1);
            resetHandlers();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            hotAirGame.showLevel(level);
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

    private static float SCREEN_WIDTH;
    private static float SCREEN_HEIGHT;
    private static float ASPECT_RATIO;

    private final static int WORLD_WIDTH = 15;
    private final static int WORLD_HEIGHT = 30;

    private final String BACKGROUND_PATH = "img/countryside.jpg";

    private Texture backgroundTexture;
    private Sprite backgroundSprite;
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

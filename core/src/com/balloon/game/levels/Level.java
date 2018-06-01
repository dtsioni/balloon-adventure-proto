package com.balloon.game.levels;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.balloon.game.Constants;
import com.balloon.game.entitys.Entity;
import com.balloon.game.factorys.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    public Level() {
        world = new World(new Vector2(0, GRAVITY), true);
        windFactory = new WindFactory(world);
        balloonFactory = new BalloonFactory(world);
        wallFactory = new WallFactory(world);
        starFactory = new StarFactory(world);
        mineFactory = new MineFactory(world);
    }

    public List<Body> getBodys() {
        return bodys;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public abstract Vector2 getCameraPosition();
    public abstract float getCameraZoom();
    public abstract int getWorldWidth();

    public abstract int getNumberOfStars();

    public World getWorld() {
        return world;
    }


    protected void addEntity(Entity entity, float x, float y) {
        entity.getBody().setTransform(x, y, entity.getRotation() * Constants.DEGREES_TO_RADIANS);
        bodys.add(entity.getBody());
        actors.add((Actor) entity.getBody().getUserData());
    }

    /* will set position to grid position x, y */
    /* will also add the user data as an actor */
    protected void addEntityOnGrid(Entity entity, int x, int y) {
        addEntityOnHalfGrid(entity, x * 2, y * 2);
    }

    protected void addEntityOnHalfGrid(Entity entity, int x, int y) {
        addEntity(entity, (x / 2f) * GRID_SIZE, (y / 2f) * GRID_SIZE);
    }

    protected void addWallsLine(int x1, int y1, int x2, int y2, int offsetX, int offsetY) {
        for(int x = x1 + offsetX; x <= x2 + offsetX; x+=2) {
            for(int y = y1 + offsetY; y <= y2 + offsetY; y+=2) {
                if(x1 == x2) {
                    addEntityOnHalfGrid(wallFactory.wallVertical(), x, y);
                }

                if(y1 == y2) {
                    addEntityOnHalfGrid(wallFactory.wallHorizontal(), x, y);
                }
            }
        }
    }

    protected void createRoom(int x, int y) {
        addWallsLine(0, 0, x, 0, 0, -1);
        addWallsLine(0, 0, 0, y, -1, 0);
        addWallsLine(0, y, x, y, 0, 1);
        addWallsLine(x, 0, x, y, 1, 0);
    }


    private World world;
    protected static WindFactory windFactory;
    protected static BalloonFactory balloonFactory;
    protected static WallFactory wallFactory;
    protected static StarFactory starFactory;
    protected static MineFactory mineFactory;

    protected static final int GRID_SIZE = Constants.GRID_SIZE;
    private static final int HALF_GRID = GRID_SIZE / 2;
    protected static final int MARGIN = 4;
    private static final int GRAVITY = -90;

    private List<Body> bodys = new ArrayList<Body>();
    private List<Actor> actors = new ArrayList<Actor>();
}

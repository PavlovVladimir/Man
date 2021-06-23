package com.binarylab.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.binarylab.game.entities.Man;
import com.binarylab.game.entities.Shit;
import com.binarylab.game.util.Constants;

public class Level {
    public static final String TAG = Level.class.getName();
    public Viewport viewport;
    Man man;
    private DelayedRemovalArray<Shit> shits;

    public Level() {
        viewport = new ExtendViewport(Constants.WORLD_SIZE_WIDTH, Constants.WORLD_SIZE_HEGHT);
        man = new Man(new Vector2(Constants.WORLD_SIZE_WIDTH / 2, 0), this);
        shits = new DelayedRemovalArray<>();
    }

    public DelayedRemovalArray<Shit> getShits() {
        return shits;
    }

    public void update(float delta) {

        man.update(delta);
        if (MathUtils.random() < delta * Constants.SHIT_SPAWNS_PER_SECOND) {
            Vector2 newShitPosition = new Vector2(
                    MathUtils.random() * viewport.getWorldWidth(),
                    viewport.getWorldHeight()
            );
            Shit newShit = new Shit(newShitPosition);
            shits.add(newShit);
        }

        for (Shit shit : shits) {
            shit.update(delta);
        }

        shits.begin();

        // TODO: Remove any icicle completely off the bottom of the screen
        for (int i = 0; i < shits.size; i++) {
            if (shits.get(i).position.y < 0) {
                shits.removeIndex(i);
            }
        }
        // TODO: End removal session
        shits.end();
    }

    public void render(SpriteBatch batch) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        for (Shit shit : shits) {
            shit.render(batch);
        }
        man.render(batch);

        batch.end();
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Man getMan() {
        return man;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public static Level debugLevel() {
        Level level = new Level();
        level.initializeLevel();
        return level;
    }

    private void initializeLevel() {
        man = new Man(new Vector2(Constants.WORLD_SIZE_WIDTH / 2, 0), this);
        shits = new DelayedRemovalArray<>();

        shits.add(new Shit(new Vector2(100, 100)));

    }

}

package com.binarylab.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.binarylab.game.util.Assets;
import com.binarylab.game.util.Constants;

public class GamePlayScreen extends ScreenAdapter {
    public static final String TAG = GamePlayScreen.class.getName();

    SpriteBatch batch;
    private Level level;

    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);
        batch = new SpriteBatch();
        startNewLevel();
    }

    @Override
    public void render(float delta) {
        level.update(delta);
//        viewport.apply();

        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level.render(batch);
    }

    @Override
    public void resize(int width, int height) {

        level.viewport.update(width, height, true);
    }

    private void startNewLevel() {

        level = Level.debugLevel();
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
    }
}

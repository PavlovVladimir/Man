package com.binarylab.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.binarylab.game.overlays.GameOverOverlay;
import com.binarylab.game.overlays.ManHud;
import com.binarylab.game.util.Assets;
import com.binarylab.game.util.Constants;
import com.binarylab.game.util.Utils;

public class GamePlayScreen extends ScreenAdapter {
    public static final String TAG = GamePlayScreen.class.getName();

    SpriteBatch batch;
    private Level level;
    private GameOverOverlay gameOverOverlay;
    private ManHud hud;
    long levelEndOverlayStartTime;
    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);
        batch = new SpriteBatch();
        gameOverOverlay = new GameOverOverlay();
        hud = new ManHud();
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
        hud.render(batch, level.getMan().getLives(),level.score);
        renderLevelEndOverlays(batch);
    }

    private void renderLevelEndOverlays(SpriteBatch batch) {
        if (level.gameOver) {
            if (levelEndOverlayStartTime == 0) {
                levelEndOverlayStartTime = TimeUtils.nanoTime();
                gameOverOverlay.init();
            }
            gameOverOverlay.render(batch, level.score);
            if (Utils.secondsSince(levelEndOverlayStartTime) > Constants.LEVEL_END_DURATION) {
                levelEndOverlayStartTime = 0;
                levelFailed();
            }
        }

    }

    private void levelFailed() {
        startNewLevel();
    }

    @Override
    public void resize(int width, int height) {
        hud.viewport.update(width, height, true);
        level.viewport.update(width, height, true);
        gameOverOverlay.viewport.update(width, height, true);
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

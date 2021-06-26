package com.binarylab.game.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.binarylab.game.util.Constants;

public class GameOverOverlay {

    public static final String TAG = GameOverOverlay.class.getName();
    public final Viewport viewport;
    final BitmapFont font;
    long startTime;

    public GameOverOverlay() {
        this.viewport = new ExtendViewport(Constants.WORLD_SIZE_WIDTH, Constants.WORLD_SIZE_HEGHT);

        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(1);
    }

    public void init() {
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch, int score) {
        String gameOverMessage = Constants.GAME_OVER_MESSAGE + "\nScore: " + score;
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, gameOverMessage, viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2.5f, 0, Align.center, false);
        batch.end();
    }
}

package com.binarylab.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.TimeUtils;
import com.binarylab.game.Level;
import com.binarylab.game.util.Assets;
import com.binarylab.game.util.Constants;
import com.binarylab.game.util.Utils;

public class Man {
    public static final String TAG = Man.class.getName();

    private Level level;
    private Vector2 position;
    private Vector2 spawnLocation;
    private Vector2 velocity;
    private int lives;
    private boolean move = true;
    private long shitStartTime;

    public Man(Vector2 spawnLocation, Level level) {
        this.spawnLocation = spawnLocation;
        this.level = level;
        position = new Vector2();
        velocity = new Vector2();
        init();
    }

    public void init() {
        lives = Constants.INITIAL_LIVES;
        respawn();
    }

    private void respawn() {
        position.set(spawnLocation);
        velocity.setZero();
    }

    public void update(float delta) {
        Rectangle manBounds = new Rectangle(
                position.x,// - Constants.TITLE_SIZE,
                position.y,// + Constants.TITLE_SIZE,
                32,
                32
        );

        DelayedRemovalArray<Shit> shits = level.getShits();
        shits.begin();
        for (int i = 0; i < shits.size; i++) {
            Shit shit = shits.get(i);
            Rectangle shitBounds = new Rectangle(
                    shit.position.x - Constants.SHIT_CENTER.x,
                    shit.position.y - Constants.SHIT_CENTER.y,
                    32,//Assets.instance.shitAssets.shit.getRegionWidth(),
                    32//Assets.instance.shitAssets.shit.getRegionHeight()
            );
            if (manBounds.overlaps(shitBounds)) {
                lives--;
                respawn();
                shitStartTime = TimeUtils.nanoTime();
//                if (lives > -1) {
//                    respawn();
//                }
                Gdx.app.log(TAG, "SHIT HAPPENS");
            }
//            if (shit.position.y <= -100) {
//                shits.removeIndex(i);
//            }
        }
        shits.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && move) {
            position.x -= delta * Constants.PLAYER_MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && move) {
            position.x += delta * Constants.PLAYER_MOVEMENT_SPEED;
        }
        ensureInBounds();
    }

    private void ensureInBounds() {
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x + Constants.TILE_SIZE * 2 > Gdx.graphics.getWidth()) {
            position.x = Gdx.graphics.getWidth() - 64;
        }
    }

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.manAssets.standing;
        if (lives < 0) {
            float shitTimeSeconds = Utils.secondsSince(shitStartTime);
            region = (TextureRegion) Assets.instance.manAssets.animation.getKeyFrame(shitTimeSeconds, false);
        }

        Utils.drawTextureRegion(batch, region, position);

    }

    public Vector2 getPosition() {
        return position;
    }

    public int getLives() {
        return lives;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}

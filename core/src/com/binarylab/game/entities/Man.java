package com.binarylab.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.binarylab.game.Level;
import com.binarylab.game.util.Assets;
import com.binarylab.game.util.Constants;
import com.binarylab.game.util.Enums;
import com.binarylab.game.util.Utils;

public class Man {
    public static final String TAG = Man.class.getName();

    private Level level;
    private Vector2 position;
    private Vector2 spawnLocation;
    private Vector2 velocity;
    int live = 3;

    public Man(Vector2 spawnLocation, Level level) {
        this.spawnLocation = spawnLocation;
        this.level = level;
        position = new Vector2();
        velocity = new Vector2();
    }

    public void init() {
        respawn();
    }

    private void respawn() {
        position.set(spawnLocation);
        velocity.setZero();
    }

    public void update(float delta) {
        Rectangle manBounds = new Rectangle(
                position.x,
                position.y,
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
                    Assets.instance.shitAssets.shit.getRegionWidth(),
                    Assets.instance.shitAssets.shit.getRegionHeight()
            );
            if (manBounds.overlaps(shitBounds)) {
                live--;
            }
            if (shit.position.y <= 0) {
                shits.removeIndex(i);
            }
        }
        shits.end();

    }
    public void render(SpriteBatch batch){
        TextureRegion region = Assets.instance.manAssets.standing;

        Utils.drawTextureRegion(batch, region, position);

    }

    public Vector2 getPosition() {
        return position;
    }
}

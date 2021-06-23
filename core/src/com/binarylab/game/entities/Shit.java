package com.binarylab.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.binarylab.game.util.Assets;
import com.binarylab.game.util.Constants;
import com.binarylab.game.util.Utils;

public class Shit {
    public Vector2 position;
    Vector2 velocity;

    public Shit(Vector2 position) {
        this.position = position;
        this.velocity = new Vector2();
    }
    public void update(float delta) {
        velocity.mulAdd(Constants.SHIT_ACCELERATION, delta);
        position.mulAdd(velocity, delta);
    }

    public void render(SpriteBatch batch) {
        final TextureRegion region = Assets.instance.shitAssets.shit;
        Utils.drawTextureRegion(batch, region, position, Constants.SHIT_CENTER);
    }
}

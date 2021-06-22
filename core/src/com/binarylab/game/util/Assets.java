package com.binarylab.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();
    private AssetManager assetManager;

    public CodeCarAssets codeCarAssets;
    public ForestAssets forestAssets;


    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(com.binarylab.game.util.Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        codeCarAssets = new CodeCarAssets(atlas);
        forestAssets = new ForestAssets(atlas);

    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class CodeCarAssets {

        // Add a AtlasRegion to hold the standing-right and other sprite
        public final AtlasRegion standingRight;
        public final AtlasRegion standingLeft;
        public final AtlasRegion standingUp;
        public final AtlasRegion standingDown;

        public final Animation walkingLeftAnimation;
        public final Animation walkingRightAnimation;
        public final Animation walkingUpAnimation;
        public final Animation walkingDownAnimation;

        public CodeCarAssets(TextureAtlas atlas) {
            // Used atlas.findRegion() to initialize the standing right AtlasRegion
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);
            standingUp = atlas.findRegion(Constants.STANDING_UP);
            standingDown = atlas.findRegion(Constants.STANDING_DOWN);

            Array<AtlasRegion> walkingLeftFrames = new Array<AtlasRegion>();
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_1));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_2));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_3));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_4));
            walkingLeftAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingLeftFrames, PlayMode.LOOP);

            Array<AtlasRegion> walkingRightFrames = new Array<>();
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_1));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_3));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_4));
            walkingRightAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingRightFrames, PlayMode.LOOP);

            Array<AtlasRegion> walkingUpframes = new Array<>();
            walkingUpframes.add(atlas.findRegion(Constants.WALKING_UP_1));
            walkingUpframes.add(atlas.findRegion(Constants.WALKING_UP_2));
            walkingUpframes.add(atlas.findRegion(Constants.WALKING_UP_3));
            walkingUpframes.add(atlas.findRegion(Constants.WALKING_UP_4));
            walkingUpAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingUpframes, PlayMode.LOOP);

            Array<AtlasRegion> walkingDownframes = new Array<>();
            walkingDownframes.add(atlas.findRegion(Constants.WALKING_DOWN_1));
            walkingDownframes.add(atlas.findRegion(Constants.WALKING_DOWN_2));
            walkingDownframes.add(atlas.findRegion(Constants.WALKING_DOWN_3));
            walkingDownframes.add(atlas.findRegion(Constants.WALKING_DOWN_4));
            walkingDownAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingDownframes, PlayMode.LOOP);

            // TODO: Add rotations animation
        }
    }

    public class ForestAssets {
        public final AtlasRegion tree;

        public ForestAssets(TextureAtlas atlas) {
            tree = atlas.findRegion(Constants.TREE_ASSET);

        }
    }
}

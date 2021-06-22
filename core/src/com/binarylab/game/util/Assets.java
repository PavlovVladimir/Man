package com.binarylab.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();
    private AssetManager assetManager;

    public ManAssets manAssets;
    public ShitAssets shitAssets;


    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(com.binarylab.game.util.Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        manAssets = new ManAssets(atlas);
        shitAssets = new ShitAssets(atlas);

    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class ManAssets {

        public final AtlasRegion standing;

        public ManAssets(TextureAtlas atlas) {
            standing = atlas.findRegion(Constants.STANDING);
        }
    }

    public class ShitAssets {
        public final AtlasRegion shit;

        public ShitAssets(TextureAtlas atlas) {
            shit = atlas.findRegion(Constants.SHIT_ASSET);

        }
    }
}

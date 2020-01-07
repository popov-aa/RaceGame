package com.popov.racegame.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    private AssetManager assetManager;

    public Assets() {
        assetManager = new AssetManager();
        assetManager.load("atlas1.atlas", TextureAtlas.class);
        assetManager.finishLoading();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void dispose() {
        assetManager.dispose();
    }
}

package com.popov.racegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.popov.racegame.utils.Assets;
import com.popov.racegame.view.GameScreen;

public class RaceGame extends Game {

	private GameScreen gameScreen;
	private Assets assets;

	@Override
	public void create() {
		assets = new Assets();
		gameScreen = new GameScreen();
		gameScreen.setTextureAtlas(assets.getAssetManager().get("atlas1.atlas", TextureAtlas.class));
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		gameScreen.dispose();
		assets.dispose();
	}
}

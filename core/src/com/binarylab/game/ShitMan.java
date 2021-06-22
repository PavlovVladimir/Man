package com.binarylab.game;

import com.badlogic.gdx.Game;

public class ShitMan extends Game {
	@Override
	public void create() {
		setScreen(new GamePlayScreen());
	}

}
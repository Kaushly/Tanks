package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	GameScreen gameScreen;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new GameScreen();
	}

	public void update(float dt){
		gameScreen.update(dt);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		gameScreen.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameScreen.dispose();
	}
}

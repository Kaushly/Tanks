package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen {
    Player player;
    Enemy enemy;
    Bullet bullet;


    public GameScreen() {
        player = new Player();
        enemy = new Enemy();
        bullet = new Bullet();
    }

    public void update(float dt) {
        player.update(dt);
        enemy.update(dt);
        if(player.getBullet().isActive()){
            checkBullet(player.getBullet());
        }
    }

    public void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        player.render(batch);
        enemy.render(batch);
        batch.end();
    }

    public void checkBullet(Bullet bullet){
        if (enemy.getCircle().contains(bullet.getPosition())) {
            bullet.deactivate();
            enemy.dispose();
            enemy = new Enemy();
        }
    }

    public void dispose() {
        player.dispose();
        enemy.dispose();
    }
}

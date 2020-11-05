package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Bullet {
    private Texture bullet;
    private Vector2 position;
    private float vx;
    private float vy;
    private float speed;
    private float angle;
    private boolean active;


    public Bullet() {
        bullet = new Texture("tank/bullet1.png");
        speed = 800;

    }

    public void deactivate(){
        this.active = false;
    }

    public void shoot(float x, float y, float angle){
        this.position = new Vector2(x,y);
        this.vx = speed * MathUtils.cosDeg(angle);
        this.vy = speed * MathUtils.sinDeg(angle);
        this.angle = angle;
        this.active = true;
    }

    public void update(float dt){
        position.x += vx * dt;
        position.y += vy * dt;
        if(position.x > 1280 || position.x < 0 || position.y > 720 || position.y < 0){
            deactivate();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(bullet, position.x - bullet.getWidth() / 2.0f, position.y - bullet.getHeight() / 2.0f, bullet.getWidth() / 2.0f, bullet.getHeight() / 2.0f, bullet.getWidth(), bullet.getHeight(), 0.3f,0.3f,angle,0,0, bullet.getWidth(), bullet.getHeight(), false, false);
    }

    public void dispose(){
        bullet.dispose();
    }

    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }
}

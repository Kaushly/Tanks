package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Player extends Tanks {
    private Bullet bullet;

    public Player() {
        tank = new Texture("tank/tank4.png");
        weapon = new Texture("tank/weapon1.png");
        position = new Vector2(100, 100);
        circle = new Circle(position.x, position.y, tank.getWidth() / 2.0f * scale);
        bullet = new Bullet();
    }

    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            angle += 90.0f * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            angle -= 90.0f * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            position.x += speed * MathUtils.cosDeg(angle) * dt;
            position.y += speed * MathUtils.sinDeg(angle) * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            position.x -= speed * MathUtils.cosDeg(angle) * dt * 0.2f;
            position.y -= speed * MathUtils.sinDeg(angle) * dt * 0.2f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            angleWeapon += 135.0f * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.E)){
            angleWeapon -= 135.0f * dt;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !bullet.isActive()){
            bullet.shoot(position.x + 20  * scale * MathUtils.cosDeg(angle), position.y + 20 * scale * MathUtils.sinDeg(angle) , angle+angleWeapon);
        }

        if(bullet.isActive()){
            bullet.update(dt);
        }
        circle.setPosition(position);
        screen();
    }

    public void render(SpriteBatch batch){
        batch.draw(tank, position.x - tank.getWidth() / 2.0f, position.y - tank.getHeight() / 2.0f, tank.getWidth() / 2.0f, tank.getHeight() / 2.0f, tank.getWidth(), tank.getHeight(), scale, scale, angle, 0, 0, tank.getWidth(), tank.getHeight(), false, false);
        batch.draw(weapon, position.x - weapon.getWidth() / 3.0f, position.y - weapon.getHeight() / 2.0f, weapon.getWidth() / 3.0f, weapon.getHeight() / 2.0f, weapon.getWidth(), weapon.getHeight(), scale, scale, angle + angleWeapon, 0, 0, weapon.getWidth(), weapon.getHeight(), false, false);

        if(bullet.isActive()){
            bullet.render(batch);
        }
    }

    public void dispose(){
        bullet.dispose();
    }

    public Bullet getBullet() {
        return bullet;
    }
}

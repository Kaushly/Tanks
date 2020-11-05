package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Tanks {
    protected Texture tank;
    protected Texture weapon;
    protected Vector2 position;
    protected float speed;
    protected float angle;
    protected float angleWeapon;
    protected float scale;
    protected Circle circle;

    public Tanks() {
        scale = 0.3f;
        speed = 240.0f;
        angle = 0.0f;
        angleWeapon = 0.0f;
    }

    protected void screen() {
        if(position.x >= Gdx.graphics.getWidth() - circle.radius){
            position.x = Gdx.graphics.getWidth() - circle.radius;
        }
        if(position.x <= circle.radius){
            position.x = circle.radius;
        }
        if(position.y >= Gdx.graphics.getHeight() - circle.radius){
            position.y = Gdx.graphics.getHeight() - circle.radius;
        }
        if(position.y <= circle.radius){
            position.y = circle.radius;
        }
    }

    public void dispose() {
        tank.dispose();
        weapon.dispose();
    }
}

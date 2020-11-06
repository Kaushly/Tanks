package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Tanks {
    private Direction prevDirection;
    private float reset;

    public Enemy() {
        tank = new Texture("tank/tank2.png");
        weapon = new Texture("tank/weapon2.png");
        position = new Vector2(MathUtils.random(100, Gdx.graphics.getWidth()), MathUtils.random(100, Gdx.graphics.getHeight()));
        circle = new Circle(position.x, position.y, tank.getWidth() / 2.0f * scale);
        prevDirection = Direction.LEFT;
        reset = 1.0f;


    }

    public void update(float dt) {
        reset = reset - dt;
        if(reset < 0) {
            prevDirection = Direction.values()[MathUtils.random(0, Direction.values().length - 1)];
            angle = prevDirection.getAngle();
            reset = 1.0f;
        }
        position.x += speed * prevDirection.getVx() * dt;
        position.y += speed * prevDirection.getVy() * dt;
        circle.setPosition(position);
        screen();

    }

    public void render(SpriteBatch batch) {
        batch.draw(tank, position.x - tank.getWidth() / 2.0f, position.y - tank.getHeight() / 2.0f, tank.getWidth() / 2.0f, tank.getHeight() / 2.0f, tank.getWidth(), tank.getHeight(), scale, scale, angle, 0, 0, tank.getWidth(), tank.getHeight(), false, false);
        batch.draw(weapon, position.x - weapon.getWidth() / 3.0f, position.y - weapon.getHeight() / 2.0f, weapon.getWidth() / 3.0f, weapon.getHeight() / 2.0f, weapon.getWidth(), weapon.getHeight(), scale, scale, angle + angleWeapon, 0, 0, weapon.getWidth(), weapon.getHeight(), false, false);
    }

    public Circle getCircle() {
        return circle;
    }
}

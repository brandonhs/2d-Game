package com.sky.engine;

import com.sky.engine.physics.Gravity;

import java.awt.*;

public class Player {
    private Sprite sprite;
    public float x, y, width, height, speed_x, speed_y,  max_speed_x, max_speed_y;
    public boolean isAlive = true;
    public boolean isJumping = false;
    public boolean canJump = true;
    public boolean hasGravity;
    public Gravity gravity;
    private Gravity jump;
    private float mass;
    public float gravitySpeed = -1;

    public Player(Sprite sprite, float x, float y, float max_speed_x, float max_speed_y, Gravity gravity) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.max_speed_x = max_speed_x;
        this.max_speed_y = max_speed_y;
        this.width = sprite.getWidth();
        this.height = sprite.getHeight();
        this.gravity = gravity;
        this.jump = new Gravity(-gravity.pull*800);
    }

    public void draw(Graphics g) {
        sprite.draw(g, (int)x, (int)y);
    }

    public void jump(float dt) {
        jump.accelerate(this, 1);
        jump.gravitySpeed = 0;
    }

    public void update(float dt) {
        gravity.accelerate(this, dt);
    }
}

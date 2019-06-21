package com.sky.engine;

import java.awt.*;

public class GameObject {
    private Sprite sprite;
    public float x, y, width ,height;
    public boolean isAlive = true;

    public GameObject(Sprite sprite, float x, float y) {
        this.sprite = sprite;
        this.width = sprite.getWidth();
        this.height = sprite.getHeight();
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        sprite.draw(g, (int)x, (int)y);
    }
}

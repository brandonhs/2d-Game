package com.sky.engine.physics;

import com.sky.engine.GameObject;
import com.sky.engine.Player;

public class Gravity {
    public float pull;
    public float gravitySpeed = 0;

    public Gravity(float pull) {
        this.pull = pull;
    }

    public void accelerate(GameObject o) {

    }

    public void accelerate(Player p, float dt) {
        gravitySpeed += pull;
        p.y += gravitySpeed * dt;
    }
}

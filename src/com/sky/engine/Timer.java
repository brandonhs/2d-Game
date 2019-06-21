package com.sky.engine;

public class Timer {
    public float deltaTime;
    private double lastLoopTime;

    public Timer() { }

    public void init() {
        lastLoopTime = getTime();
    }

    public void update() {
        getDeltaTime();
    }

    private void getDeltaTime() {
        double time = getTime();
        deltaTime = (float)(time-lastLoopTime);
        lastLoopTime = time;
    }

    private double getTime() {
        return System.nanoTime() / 1_000_000_000.0;
    }
}

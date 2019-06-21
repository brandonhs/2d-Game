package com.sky.engine;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    public Window window = null;
    private Timer timer = new Timer();

    public void run() {
        start();
        timer.init();

        if (window == null)
            throw new Error("Window has not been defined. Program cannot continue.");

        window.create(this);

        // temporary game loop
        while (true) {
            timer.update();
            update(timer.deltaTime);
            repaint();
        }
    }

    public void clearScreen(Graphics g) {
        super.paint(g);
    }

    // override
    public void update(float dt) { }

    public void start() { }

    public void processInputs(int p, int r) { }

    // JPanel overrides
    @Override
    public void paint(Graphics g) {

    }
}

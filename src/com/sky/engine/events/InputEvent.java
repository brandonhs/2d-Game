package com.sky.engine.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.sky.engine.Game;

public class InputEvent implements KeyListener {
    public String name;
    private int[] keys;
    private Game game;

    public InputEvent(int[] keys, Game game) {
        this.keys = keys;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == e.getKeyCode()) {
                game.processInputs(i, -1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == e.getKeyCode()) {
                game.processInputs(-1, i);
            }
        }
    }
}

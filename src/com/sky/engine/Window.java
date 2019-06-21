package com.sky.engine;

import javax.swing.*;

public class Window extends JFrame {
    private int width, height;
    private String title;
    boolean resizable, undecorated;

    public Window(int width, int height, String title, boolean resizable, boolean undecorated) {
        this.width = width;
        this.height = height;
        this.title = title;

        this.resizable = resizable;
        this.undecorated = undecorated;
    }

    public void create(JPanel game) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setResizable(resizable);
        this.setUndecorated(undecorated);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(game);
        this.setVisible(true);
    }
}

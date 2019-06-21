package com.sky.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    public BufferedImage image;
    public String path;

    public Sprite(String path) {
        this.path = path;

        //image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public int getWidth() { return image.getWidth(); }

    public int getHeight() { return image.getHeight(); }
}

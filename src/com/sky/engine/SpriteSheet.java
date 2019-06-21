package com.sky.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage image;
    private Sprite[][] sprites;

    public SpriteSheet(String path, int spriteWidth, int spriteHeight) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) { System.out.println(e.getMessage()); }

        sprites = new Sprite[image.getWidth()/spriteWidth][image.getHeight()/spriteHeight];

        for (int i = 0; i < sprites.length; i++) {
            for (int j = 0; j < sprites[i].length; j++) {
                sprites[i][j] = new Sprite(image.getSubimage(i*spriteWidth, j*spriteHeight, spriteWidth, spriteHeight));
            }
        }
    }

    public Sprite getSprite(int x, int y) {
        return sprites[x][y];
    }
}

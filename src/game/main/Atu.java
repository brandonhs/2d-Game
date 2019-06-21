package game.main;

import com.sky.engine.*;
import com.sky.engine.Window;
import com.sky.engine.events.InputEvent;
import com.sky.engine.physics.Gravity;

import java.awt.*;

public class Atu extends Game {
    private Player player = null;
    private SpriteSheet spriteSheet = null;
    private InputEvent arrowKeys = new InputEvent(new int[] {
            37, 38, 39, 40, // LEFT UP RIGHT DOWN
            65, 87, 68, 83  // A W D S
    }, this);
    private GameObject test;

    @Override
    public void start() {
        setFocusable(true);
        // create the window
        window = new Window(640, 480, "Adventure Through the Unknown", false, false);
        // load sprite sheet
        spriteSheet = new SpriteSheet("src/game/assets/img/spriteSheetTest2.png", 32, 32);
        // create player
        player = new Player(spriteSheet.getSprite(0, 0), 0f, 0f, 100, 100, new Gravity(0.1f));
        // create new test object
        test = new GameObject(spriteSheet.getSprite(1, 0), 0, 440);
        // addKeyListener to arrowKeys
        addKeyListener(arrowKeys);
    }

    @Override
    public void update(float dt) {
        System.out.println("Delta: " + dt);
        player.x += player.speed_x * dt;
        player.y += player.speed_y * dt;

        if (       player.x > test.x - player.width
                && player.x < test.x + test.width
                && player.y > test.y - player.height
                && player.y < test.y + player.height
                && test.isAlive
        ) {
            player.y = test.y - player.height;
            player.gravity.gravitySpeed = 0;
        }

        if (player.isJumping) {
            player.jump(dt);
            player.isJumping = false;
        }

        player.update(dt);
    }

    @Override
    public void processInputs(int p, int r) {
        // left pressed
        if (p == 0 || p == 4) {
            player.speed_x = -player.max_speed_x;
        }
        // up pressed
        if (p == 1 || p == 5) {
            player.isJumping = true;
        }
        // right pressed
        if (p == 2 || p == 6) {
            player.speed_x = player.max_speed_x;
        }
        // down pressed
        if (p == 3 || p == 7) {
            player.speed_y = player.max_speed_y;
        }

        // left released
        if (r == 0 || r == 4) {
            player.speed_x = 0;
        }

        // up released
        if (r == 1 || r == 5) {
            player.speed_y = 0;
        }

        // right released
        if (r == 2 || r == 6) {
            player.speed_x = 0;
        }

        // down released
        if (r == 3 || r == 7) {
            player.speed_y = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        clearScreen(g);
        if (test.isAlive)
            test.draw(g);
        player.draw(g);
    }

    public static void main(String[] args) {
        new Atu().run();
    }
}

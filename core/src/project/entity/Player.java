package project.entity;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.animation.player.PlayerAnimation;
import project.misc.Log;

public class Player extends Entity {
    public final static int WIDTH = 24, HEIGHT = 32;
    private final static Player INSTANCE = new Player();

    boolean isUp, isDown, isRight, isLeft, isIdle;

    private PlayerAnimation.PlayerRight player_right;
    private PlayerAnimation.PlayerLeft player_left;
    private PlayerAnimation.PlayerRightIdle player_right_idle;
    private PlayerAnimation.PlayerLeftIdle player_left_idle;

    private Player() {
        super();
        super.setSize(WIDTH, HEIGHT);

        System.out.println("this is a player");
        position.set(512, 50);
        isUp = isDown = isLeft = false;
        isRight = true;
        isIdle = true;
    }

    public static Player getInstance() {
        return INSTANCE;
    }

    public void create() {
        System.out.println("Created Player");

        player_right = new PlayerAnimation.PlayerRight();
        player_right.setPosition(position);

        player_left = new PlayerAnimation.PlayerLeft();
        player_left.setPosition(position);

        player_right_idle = new PlayerAnimation.PlayerRightIdle();
        player_right_idle.setPosition(position);

        player_left_idle = new PlayerAnimation.PlayerLeftIdle();
        player_left_idle.setPosition(position);
    }

    private void move() {
        int speed = 4;
        isIdle = false;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.add(0, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.add(0, -speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            isLeft = true;
            isRight = false;
            position.add(-speed, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            isLeft = false;
            isRight = true;
            position.add(speed, 0);
        } else {
            isIdle = true;
            // isRight = isLeft = false;
        }
    }

    private void boundary() {
        if (position.x > Gdx.graphics.getWidth() - WIDTH)
            position.x = -WIDTH;
        if (position.x < -WIDTH)
            position.x = Gdx.graphics.getWidth() - WIDTH;
        if (position.y > Gdx.graphics.getHeight() - HEIGHT)
            position.y = -HEIGHT;
        if (position.y < -HEIGHT)
            position.y = Gdx.graphics.getHeight() - HEIGHT;
    }

    @Override
    public void render(SpriteBatch batch) {
        // super.setGravity();
        this.boundary();
        this.move();
        // player_right.render(batch);
        if (isIdle) {
            if (isRight) {
                player_right_idle.render(batch);
            } else if (isLeft) {
                player_left_idle.render(batch);
            }
        } else {
            if (!isLeft && isRight) {
                player_right.render(batch);
            } else if (!isRight && isLeft) {
                player_left.render(batch);
            }
        }

    }

    @Override
    public void dispose() {
        player_right.dispose();
        player_left.dispose();
        player_right_idle.dispose();
        player_left_idle.dispose();
        Log.getInstance().setLog("Player dispose");
    }

}

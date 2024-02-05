/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.entity;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.animation.player.PlayerAnimation;
import project.misc.Log;

public class Player extends Entity {
    private final static Player INSTANCE = new Player();
    boolean isUp, isDown, isRight, isLeft, isIdle;
    private Texture texture;

    private PlayerAnimation.PlayerRight player_right;

    private Player() {
        System.out.println("this is a player");
        position.set(45, 45);
        isUp = isDown = isRight = isLeft = false;
        isIdle = true;
    }

    public static Player getInstance() {
        return INSTANCE;
    }

    public void create() {
        System.out.println("Created Player");
        texture = new Texture("player/player.png");
        player_right = new PlayerAnimation.PlayerRight();
        player_right.setPosition(position);
    }

    private void move() {
        int speed = 4;

        if (Gdx.input.isKeyPressed(Input.Keys.UP) &&
                !Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.add(0, speed);
            isIdle = false;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
                !Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.add(0, -speed);
            isIdle = false;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.UP) &&
                !Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            isIdle = false;
            position.add(-speed, 0);
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.UP) &&
                !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            isIdle = false;
            position.add(speed, 0);
        }

        else
            isIdle = true;
    }

    private void boundary() {
        if (position.x > Gdx.graphics.getWidth() + texture.getWidth())
            position.x = -texture.getWidth();
        if (position.x < -texture.getWidth())
            position.x = Gdx.graphics.getWidth() + texture.getWidth();
        if (position.y > Gdx.graphics.getHeight() + texture.getHeight())
            position.y = -texture.getHeight();
        if (position.y < -texture.getHeight())
            position.y = Gdx.graphics.getHeight() + texture.getHeight();
    }

    @Override
    public void render(SpriteBatch batch) {
        this.boundary();
        position.add(4, 0);
        player_right.render(batch);
    }

    @Override
    public void dispose() {
        player_right.dispose();
        texture.dispose();
        Log.getInstance().setLog("Player dispose");
    }

}

package project.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import project.entity.*;
import project.misc.CollisionDetection;
import project.misc.Log;

public class Main extends ApplicationAdapter {
    Player player = Player.getInstance();
    Enemy enemy;

    private CollisionDetection collide;
    private SpriteBatch batch;

    @Override
    public void create() {
        player.create();

        batch = new SpriteBatch();

        enemy = new Enemy();
        enemy.create();
        enemy.setSize(64, 32);

        collide = new CollisionDetection();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT |
                (Gdx.graphics.getBufferFormat().coverageSampling
                        ? GL20.GL_COVERAGE_BUFFER_BIT_NV
                        : 0));

        collide.createCollision(player, enemy);

        batch.begin();
        batch.enableBlending();
        enemy.render(batch);
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        Log.getInstance().setLog("Main Dispose");
        batch.dispose();
        player.dispose();
        enemy.dispose();
    }
}

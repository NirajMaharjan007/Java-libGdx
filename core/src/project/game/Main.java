package project.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import project.entity.Player;
import project.misc.Log;

public class Main extends ApplicationAdapter {
    Player player = Player.getInstance();
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player.create();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT
                | (Gdx.graphics.getBufferFormat().coverageSampling
                        ? GL20.GL_COVERAGE_BUFFER_BIT_NV
                        : 0));

        batch.begin();
        batch.enableBlending();
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        Log.getInstance().setLog("Main Dispose");
        batch.dispose();
        player.dispose();

    }
}

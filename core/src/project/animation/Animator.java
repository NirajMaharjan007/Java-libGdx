package project.animation;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import project.misc.Log;

public abstract class Animator implements ApplicationListener {
    protected static int FRAME_COLS = 0, FRAME_ROWS = 0;
    protected float stateTime = 0.0f, frameSpeed = 0.0f;
    protected boolean isFlipped = false;

    Vector2 position;
    Animation<TextureRegion> animation; // Must declare frame type (TextureRegion)
    Texture sheet;
    SpriteBatch spriteBatch;

    protected Animator() {
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setTexture(Texture sheet) {
        this.sheet = sheet;
    }

    public void setTexture(String path) {
        sheet = new Texture(path);
    }

    protected void setSpriteBatch(SpriteBatch batch) {
        this.spriteBatch = batch;
    }

    @Override
    public void create() {
        TextureRegion[][] tmp = TextureRegion.split(sheet,
                sheet.getWidth() / FRAME_COLS,
                sheet.getHeight() / FRAME_ROWS);

        TextureRegion[] frame = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        int index = 0;

        if (!isFlipped) {
            for (int i = 0; i < FRAME_ROWS; i++) {
                for (int j = 0; j < FRAME_COLS; j++) {
                    frame[index++] = tmp[i][j];
                }
            }
        } else {
            for (int i = FRAME_ROWS - 1; i >= 0; i--) {
                for (int j = FRAME_COLS - 1; j >= 0; j--) {
                    frame[index++] = tmp[i][j];
                }
            }
        }
        System.out.println("Animator.create() + isFlipped->" + isFlipped);

        animation = new Animation<TextureRegion>(frameSpeed, frame);

        stateTime = 0f;
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        spriteBatch.draw(currentFrame, position.x, position.y); // Draw current frame at (50, 50)
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        Log.getInstance().setLog("Disposed Animation");
        sheet.dispose();
    }
}

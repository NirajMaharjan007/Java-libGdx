package project.animation.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.animation.Animator;

public class PlayerAnimation {
    public static class PlayerRight extends Animator {
        public PlayerRight() {
            super();
            FRAME_ROWS = 1;
            FRAME_COLS = 10;
            frameSpeed = 0.056f;
            super.setTexture("player/player_right.png");
            super.create();
        }

        public void render(SpriteBatch batch) {
            super.setSpriteBatch(batch);
            super.render();
        }
    }

    public static class PlayerRightIdle extends Animator {
        public PlayerRightIdle() {
            super();
            FRAME_ROWS = 1;
            FRAME_COLS = 10;
            frameSpeed = 0.064f;
            super.setTexture("player/player_idle_right.png");
            super.create();
        }

        public void render(SpriteBatch batch) {
            super.setSpriteBatch(batch);
            super.render();
        }
    }
}

package project.animation.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.animation.Animator;

public class PlayerAnimation {
    public static class PlayerRight extends Animator {
        public PlayerRight() {
            super();
            FRAME_ROWS = 1;
            FRAME_COLS = 3;
            frameSpeed = 0.10f;
            super.setTexture("player/player_right.png");
            super.create();
        }

        public void render(SpriteBatch batch) {
            super.setSpriteBatch(batch);
            super.render();
        }
    }
}

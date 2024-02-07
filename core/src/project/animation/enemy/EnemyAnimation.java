package project.animation.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import project.animation.Animator;

public class EnemyAnimation {
    public static class EnemyIdleRight extends Animator {
        public EnemyIdleRight() {
            super();
            FRAME_ROWS = 1;
            FRAME_COLS = 10;
            frameSpeed = 0.056f;
            isFlipped = false;
            super.setTexture("enemy/idle_right.png");
            super.create();
        }

        public void render(SpriteBatch batch) {
            super.setSpriteBatch(batch);
            super.render();
        }
    }
}

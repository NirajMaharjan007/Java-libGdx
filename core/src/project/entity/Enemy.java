package project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import project.animation.enemy.EnemyAnimation.*;
import project.misc.Log;

public class Enemy extends Entity {
    public enum Type {
        Lizard,
        Zombie
    }

    private EnemyIdleRight enemyIdleRight;

    public Enemy() {
        super();
        super.setSize(24, 32);

        position.set(512, 50);
    }

    public void create() {
        enemyIdleRight = new EnemyIdleRight();
        enemyIdleRight.setPosition(position);
    }

    @Override
    public void render(SpriteBatch batch) {
        enemyIdleRight.render(batch);
    }

    @Override
    public void dispose() {
        Log.getInstance().setLog("Enemy: Disposed");
        enemyIdleRight.dispose();
    }
}

package project.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import project.misc.Log;

public class Enemy extends Entity {
    public enum Type {
        Lizard,
        Zombie
    }

    private Texture texture;

    public Enemy() {
        super();
        super.setSize(18, 24);

        position.set(512, 50);
    }

    public void create() {
        texture = new Texture("enemy/box.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void dispose() {
        Log.getInstance().setLog("Enemy: Disposed");
        texture.dispose();
    }
}

package project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import project.misc.Log;

public abstract class Entity implements Cloneable {
    protected Vector2 position;

    protected Entity() {
        position = new Vector2();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            Log.getInstance().setLog("\n" + e.getCause().toString());
            System.err.println(e.getMessage());
            return null;
        }
    }

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}

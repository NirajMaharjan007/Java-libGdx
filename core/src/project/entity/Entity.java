package project.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import project.misc.Log;

public abstract class Entity implements Cloneable {
    private int width, height;
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

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    protected void setGravity() {
        System.out.println("Entity.gravity = pulling down");
    }

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}

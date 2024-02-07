package project.misc;

import com.badlogic.gdx.math.Rectangle;

import project.entity.Entity;

public class CollisionDetection {
    public static enum Collision {
        COLLIDE,
        NONE
    }

    Entity entity1, entity2;
    Rectangle rect1, rect2;
    boolean collision = false;

    public CollisionDetection() {
        super();
    }

    public CollisionDetection(Entity entity1, Entity entity2) {
        super();
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    public boolean createCollision(Entity entity1, Entity entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;

        this.rect1 = new Rectangle(entity1.getX(), entity1.getY(),
                entity1.getWidth(), entity1.getHeight());
        this.rect2 = new Rectangle(entity2.getX(), entity2.getY(),
                entity2.getWidth(), entity2.getHeight());

        return rect1.overlaps(rect2);
    }

}

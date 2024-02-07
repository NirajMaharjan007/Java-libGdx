package project.misc;

import com.badlogic.gdx.math.Rectangle;

import project.entity.Entity;

public class CollisionDetection {
    Entity entity1, entity2;
    Rectangle rect1, rect2;

    public CollisionDetection() {
        super();
    }

    public CollisionDetection(Entity entity1, Entity entity2) {
        super();
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    public void createCollision(Entity entity1, Entity entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;

        this.rect1 = new Rectangle(entity1.getX(), entity1.getY(),
                entity1.getWidth(), entity1.getHeight());
        this.rect2 = new Rectangle(entity2.getX(), entity2.getY(),
                entity2.getWidth(), entity2.getHeight());

        if (rect1.overlaps(rect2)) {

        }
        System.out.println(entity1.getX() + " " + entity1.getY() + "\t"
                + entity2.getX() + " " + entity2.getY());
    }

}

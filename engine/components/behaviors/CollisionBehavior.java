package engine.components.behaviors;

import engine.GameObject;
import engine.components.shapes.AAB;
import engine.components.shapes.Circle;
import engine.components.shapes.Shape;
import engine.support.Vec2d;

public abstract class CollisionBehavior extends Behavior {

  public CollisionBehavior(GameObject parent) {
    super(parent);
  }

  public abstract void onCollision(Shape o);
  public abstract void onCollisionAAB(AAB aab);
  public abstract void onCollisionCircle(Circle circle);
  public abstract void onCollisionPoint(Vec2d point);
}

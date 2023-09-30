package engine.components;

import engine.GameObject;
import engine.components.shapes.AAB;
import engine.components.shapes.Circle;
import engine.components.shapes.Shape;
import engine.support.Vec2d;

public class CollisionComponent extends Component {

  private final Shape shape;

  public CollisionComponent(GameObject parent, Shape shape) {
    super(parent);

    this.shape = shape;
  }

  public void onCollision(GameObject other) {

  }

  public Shape getShape() {
    return this.shape;
  }

  @Override
  public ComponentTag getTag() {
    return ComponentTag.COLLISION;
  }
}

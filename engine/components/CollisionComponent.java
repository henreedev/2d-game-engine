package engine.components;

import engine.GameObject;
import engine.components.shapes.Shape;

public class CollisionComponent extends Component {

  private final Shape shape;

  public CollisionComponent(GameObject<?> parent, Shape shape) {
    super(parent);

    this.shape = shape;
  }

  public void onCollision(GameObject<?> other) {

  }

  public Shape getShape() {
    return this.shape;
  }

  @Override
  public ComponentTag getTag() {
    return ComponentTag.COLLISION;
  }
}

package engine.components;

import engine.GameObject;
import engine.support.Vec2d;

public class TransformComponent extends Component {

  private Vec2d position;
  private Vec2d size;

  public TransformComponent(GameObject<?> parent) {
    super(parent);
    this.position = new Vec2d(0, 0);
    this.size = new Vec2d(1, 1);
  }

  public Vec2d getPosition() {
    return position;
  }

  public Vec2d getSize() {
    return size;
  }

  public void setPosition(Vec2d position) {
    this.position = position;
  }

  public void setSize(Vec2d size) {
    this.size = size;
  }

  @Override
  public ComponentTag getTag() {
    return ComponentTag.TRANSFORM;
  }
}

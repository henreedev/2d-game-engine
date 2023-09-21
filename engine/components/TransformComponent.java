package engine.components;

import engine.GameObject;
import engine.support.Vec2d;

public class TransformComponent extends Component {

  private Vec2d position;
  private Vec2d size;

//  private boolean isFlippedHoz;
//  private boolean isFlippedVert;

  public TransformComponent(GameObject parent) {
    super(parent);
  }

  @Override
  public ComponentTag getTag() {
    return ComponentTag.TRANSFORM;
  }
}

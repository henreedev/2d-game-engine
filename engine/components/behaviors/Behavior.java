package engine.components.behaviors;

import engine.GameObject;
import engine.components.TransformComponent;

public abstract class Behavior {
  private final GameObject parent;

  public Behavior(GameObject parent) {
    this.parent = parent;
  }

  protected TransformComponent getParentTransform() {
    return this.parent.getTransform();
  }
}

package engine.components;

import engine.GameObject;

public abstract class Component {
  private boolean isActive;
  protected GameObject<?> parent;

  public Component(GameObject<?> parent) {
    this.parent = parent;
  }

  public abstract ComponentTag getTag();

}

package engine.components;

import engine.GameObject;

public abstract class Component {
  private boolean isActive;
  protected GameObject parent;

  public Component(GameObject parent) {
    this.parent = parent;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActivity(boolean isActive) {
    this.isActive = isActive;
  }

  public abstract ComponentTag getTag();

}

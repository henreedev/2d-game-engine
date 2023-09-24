package engine.components.behaviors;

import engine.GameObject;

public abstract class TickBehavior extends Behavior {

  public TickBehavior(GameObject parent) {
    super(parent);
  }

  public abstract void onTick(double deltaTime);
}

package engine.systems;

import engine.GameObject;
import engine.GameSystem;
import engine.components.ComponentTag;
import engine.components.TickComponent;

public class TickSystem extends GameSystem {

  public TickSystem() {
    super();
  }

  @Override
  public void onTick(double deltaTime) {
    for (GameObject<?> gObj : this.gameObjects) {
      TickComponent component = (TickComponent) gObj.getComponent(ComponentTag.TICK);
      component.onTick(deltaTime);
    }
  }
}

package engine.components;

import engine.GameObject;
import engine.components.behaviors.TickBehavior;

public class TickComponent extends Component {

  private TickBehavior tickBehavior;

  public TickComponent(GameObject parent, TickBehavior tickBehavior) {
    super(parent);
    this.tickBehavior = tickBehavior;
  }

  public void onTick(double deltaTime) {
    this.tickBehavior.onTick(deltaTime);
  }

  @Override
  public ComponentTag getTag() {
    return ComponentTag.TICK;
  }
}

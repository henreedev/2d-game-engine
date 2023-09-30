package engine.components;

import engine.GameObject;

public class TickComponent extends Component {

  public TickComponent(GameObject<?> parent) {
    super(parent);
  }

  public void onTick(double deltaTime) {}

  @Override
  public ComponentTag getTag() {
    return ComponentTag.TICK;
  }
}

package engine.components;

import engine.GameObject;
import engine.components.behaviors.InputBehavior;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class InputComponent extends Component {

  public InputComponent(GameObject parent) {
    super(parent);
  }

  @Override
  public ComponentTag getTag() { return ComponentTag.INPUT; }

  public void onKeyPressed(KeyEvent e) {}

  public void onKeyReleased(KeyEvent e) {}

  public void onKeyTyped(KeyEvent e) {}

  public void onMouseClicked(MouseEvent e) {}

  public void onMousePressed(MouseEvent e) {}

  public void onMouseReleased(MouseEvent e) {}

  public void onMouseDragged(MouseEvent e){}

  public void onMouseMoved(MouseEvent e) {}

  public void onMouseWheelMoved(ScrollEvent e) {}

}

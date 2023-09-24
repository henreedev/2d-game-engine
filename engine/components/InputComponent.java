package engine.components;

import engine.GameObject;
import engine.components.behaviors.InputBehavior;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class InputComponent extends Component {

  private final InputBehavior inputBehavior;

  public InputComponent(GameObject parent, InputBehavior inputBehavior) {
    super(parent);
    this.inputBehavior = inputBehavior;
  }

  @Override
  public ComponentTag getTag() { return ComponentTag.INPUT; }

  public void onKeyPressed(KeyEvent e) {
    this.inputBehavior.onKeyPressed(e);
  }

  public void onKeyReleased(KeyEvent e) {
    this.inputBehavior.onKeyReleased(e);
  }

  public void onKeyTyped(KeyEvent e) {
    this.inputBehavior.onKeyTyped(e);
  }

  public void onMouseClicked(MouseEvent e) {
    this.inputBehavior.onMouseClicked(e);
  }

  public void onMousePressed(MouseEvent e) {
    this.inputBehavior.onMousePressed(e);
  }

  public void onMouseReleased(MouseEvent e) {
    this.inputBehavior.onMouseReleased(e);
  }

  public void onMouseDragged(MouseEvent e) {
    this.inputBehavior.onMouseDragged(e);
  }

  public void onMouseMoved(MouseEvent e) {
    this.inputBehavior.onMouseMoved(e);
  }

  public void onMouseWheelMoved(ScrollEvent e) {
    this.inputBehavior.onMouseWheelMoved(e);
  }

}

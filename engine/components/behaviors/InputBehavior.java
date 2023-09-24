package engine.components.behaviors;

import engine.GameObject;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public abstract class InputBehavior extends Behavior {

  public InputBehavior(GameObject parent) {
    super(parent);
  }

  public abstract void onKeyTyped(KeyEvent e);
  public abstract void onKeyPressed(KeyEvent e);
  public abstract void onKeyReleased(KeyEvent e);
  public abstract void onMouseClicked(MouseEvent e);
  public abstract void onMousePressed(MouseEvent e);
  public abstract void onMouseReleased(MouseEvent e);
  public abstract void onMouseDragged(MouseEvent e);
  public abstract void onMouseMoved(MouseEvent e);
  public abstract void onMouseWheelMoved(ScrollEvent e);


}

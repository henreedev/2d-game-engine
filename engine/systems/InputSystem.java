package engine.systems;

import engine.GameObject;
import engine.GameSystem;
import engine.Screen;
import engine.components.ComponentTag;
import engine.components.InputComponent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class InputSystem extends GameSystem {

  public InputSystem() {
    super();
  }

  public void onKeyTyped(KeyEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onKeyTyped(e);
    }
  }

  public void onKeyPressed(KeyEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onKeyPressed(e);
    }
  }

  public void onKeyReleased(KeyEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onKeyReleased(e);
    }
  }

  public void onMouseClicked(MouseEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMouseClicked(e);
    }
  }

  public void onMousePressed(MouseEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMousePressed(e);
    }
  }

  public void onMouseReleased(MouseEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMouseReleased(e);
    }
  }

  public void onMouseDragged(MouseEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMouseDragged(e);
    }
  }

  public void onMouseMoved(MouseEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMouseMoved(e);
    }
  }

  public void onMouseWheelMoved(ScrollEvent e) {
    for (GameObject<?> gObj : this.gameObjects) {
      InputComponent component = (InputComponent) gObj.getComponent(ComponentTag.INPUT);
      component.onMouseWheelMoved(e);
    }
  }



}

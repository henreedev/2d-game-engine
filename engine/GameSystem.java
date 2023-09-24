package engine;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public abstract class GameSystem {

  protected List<GameObject> gameObjects;

  public GameSystem() {
    this.gameObjects = new ArrayList<>();
  }

  public void addGameObject(GameObject gObj) {
    gameObjects.add(gObj);
  }

  public void removeGameObject(GameObject gObj) {
    gameObjects.remove(gObj);
  }

  public void onDraw(GraphicsContext g) {}

  public void onTick(double deltaTime) {}

  public void onKeyTyped(KeyEvent e) {}

  public void onKeyPressed(KeyEvent e) {}

  public void onKeyReleased(KeyEvent e) {}

  public void onMouseClicked(MouseEvent e) {}

  public void onMousePressed(MouseEvent e) {}

  public void onMouseReleased(MouseEvent e) {}

  public void onMouseDragged(MouseEvent e) {}

  public void onMouseMoved(MouseEvent e) {}

  public void onMouseWheelMoved(ScrollEvent e) {}

}

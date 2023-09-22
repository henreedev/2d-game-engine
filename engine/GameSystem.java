package engine;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;

public class GameSystem {

  private List<GameObject> gameObjects;

  public void addGameObject(GameObject gObj) {
    gameObjects.add(gObj);
  }

  public void removeGameObject(GameObject gObj) {
    gameObjects.remove(gObj);
  }

  protected void onDraw(GraphicsContext g) {}

  protected void onTick(double deltaTime) {}
}

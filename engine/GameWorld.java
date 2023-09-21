package engine;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;

public class GameWorld {
  /* add:
   * an addGameObject(GameObject gObj) method that adds the gameObject to all relevant
   *  Systems based on its components
   * a removal queue of GameObjects, and a removeGameObject(GameObject gObj) function that adds the
   *  gameObject instance to that list. onTick and onDraw should delete objects in the queue from
   *  their respective System.
   * a public input map from string ("w", "W", "esc", etc.) to boolean (currently input or not).
   */
  System graphicsSystem;
  System timerSystem;

  protected void onDraw(GraphicsContext g) {
    if (graphicsSystem != null) {
      graphicsSystem.onDraw(g);
    }
  }

  protected void onTick(double deltaTime) {
    if (timerSystem != null) {
      timerSystem.onTick(deltaTime);
    }
  }
}

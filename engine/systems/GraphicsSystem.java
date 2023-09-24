package engine.systems;

import engine.GameObject;
import engine.GameSystem;
import engine.components.ComponentTag;
import engine.components.GraphicsComponent;
import javafx.scene.canvas.GraphicsContext;

public class GraphicsSystem extends GameSystem {

  public GraphicsSystem() {
    super();
  }

  @Override
  public void onDraw(GraphicsContext g) {
    for (GameObject gObj : this.gameObjects) {
      GraphicsComponent component = (GraphicsComponent) gObj.getComponent(ComponentTag.GRAPHICS);
      component.onDraw(g);
    }
  }
}

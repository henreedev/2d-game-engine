package engine.systems;

import engine.GameObject;
import engine.GameSystem;
import engine.components.ComponentTag;
import engine.components.GraphicsComponent;
import engine.components.DrawLayer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

public class GraphicsSystem extends GameSystem {

  List<List<GameObject<?>>> drawOrderStorage;

  public GraphicsSystem() {
    super();
    this.drawOrderStorage = new ArrayList<>();
    for (int i = 0; i < DrawLayer.values().length; i++) {
      drawOrderStorage.add(new ArrayList<>());
    }
  }

  @Override
  public void addGameObject(GameObject<?> gObj) {
    super.addGameObject(gObj);
    GraphicsComponent component = (GraphicsComponent) gObj.getComponent(ComponentTag.GRAPHICS);
    this.drawOrderStorage.get(component.getDrawLayer().ordinal()).add(gObj);
  }

  @Override
  public void removeGameObject(GameObject<?> gObj) {
    super.removeGameObject(gObj);
    GraphicsComponent component = (GraphicsComponent) gObj.getComponent(ComponentTag.GRAPHICS);
    this.drawOrderStorage.get(component.getDrawLayer().ordinal()).remove(gObj);
  }

  @Override
  public void onDraw(GraphicsContext g) {
    for (List<GameObject<?>> sublist : this.drawOrderStorage) { // draw by layer, from bottom to top
      for (GameObject<?> gObj : sublist) {
        GraphicsComponent component = (GraphicsComponent) gObj.getComponent(ComponentTag.GRAPHICS);
        g.save();
        component.onDraw(g);
        g.restore();
      }
    }
  }
}

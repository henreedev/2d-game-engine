package engine.components;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;

/**
 * Attached to a game object to allow drawing.
 */
public class GraphicsComponent extends Component {

  private final DrawLayer drawLayer;

  public GraphicsComponent(GameObject<?> parent, DrawLayer drawLayer) {
    super(parent);
    this.drawLayer = drawLayer;
  }

  public DrawLayer getDrawLayer() {
    return drawLayer;
  }

  public void onDraw(GraphicsContext g) {}

  @Override
  public ComponentTag getTag() { return ComponentTag.GRAPHICS; }
}

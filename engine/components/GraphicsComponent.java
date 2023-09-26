package engine.components;

import engine.GameObject;
import engine.components.behaviors.DrawBehavior;
import engine.components.behaviors.DrawLayer;
import javafx.scene.canvas.GraphicsContext;

/**
 * Attached to a game object to allow drawing.
 */
public class GraphicsComponent extends Component {

  private DrawBehavior drawBehavior;
  private DrawLayer drawLayer;

  public GraphicsComponent(GameObject parent, DrawBehavior drawBehavior, DrawLayer drawLayer) {
    super(parent);
    this.drawLayer = drawLayer;
    this.drawBehavior = drawBehavior;
  }

  public DrawLayer getDrawLayer() {
    return drawLayer;
  }

  public void onDraw(GraphicsContext g) {
    drawBehavior.onDraw(g);
  }

  @Override
  public ComponentTag getTag() { return ComponentTag.GRAPHICS; }
}

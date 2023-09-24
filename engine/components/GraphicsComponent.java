package engine.components;

import engine.GameObject;
import engine.components.behaviors.DrawBehavior;
import javafx.scene.canvas.GraphicsContext;

/**
 * Attached to a game object to allow drawing.
 */
public class GraphicsComponent extends Component {

  private DrawBehavior drawBehavior;

  public GraphicsComponent(GameObject parent, DrawBehavior drawBehavior) {
    super(parent);
    this.drawBehavior = drawBehavior;
  }

  public void onDraw(GraphicsContext g) {
    drawBehavior.onDraw(g);
  }

  @Override
  public ComponentTag getTag() { return ComponentTag.GRAPHICS; }
}

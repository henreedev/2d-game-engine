package engine.components.behaviors;

import engine.GameObject;
import engine.components.TransformComponent;
import javafx.scene.canvas.GraphicsContext;

public abstract class DrawBehavior extends Behavior {

  public DrawBehavior(GameObject parent) {
    super(parent);
  }

  // override this to draw sprite
  public abstract void onDraw(GraphicsContext g);
}

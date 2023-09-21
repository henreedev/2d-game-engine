package engine.components;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;

public abstract class Sprite {
  private final GameObject parent;

  public Sprite(GameObject parent) {
    this.parent = parent;
  }

  private TransformComponent getParentTransform() {
    return this.parent.getTransform();
  }

  // override this to draw sprite
  public void onDraw(GraphicsContext g) {

  }
}

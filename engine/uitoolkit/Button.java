package engine.uitoolkit;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Button extends UIElement {
  private Vec2d absPos = new Vec2d(0, 0); // initialization only
  private final ButtonBehavior behavior;

  public Button(ButtonBehavior behavior) {
    super();
    this.behavior = behavior;
  }

  @Override
  protected void onMouseClicked(MouseEvent e) {
    if(isWithinBounds(e)) {
      behavior.doOnClick(e);
    }
  }

  @Override
  protected void onMouseMoved(MouseEvent e) {
    if (isWithinBounds(e)) {
      behavior.doOnHover(e);
    }
  }

  @Override
  protected void draw(GraphicsContext g, Vec2d parentPosition) {
    this.absPos = this.position.plus(parentPosition);
  }

  private boolean isWithinBounds(MouseEvent e) {
    double leftBound = this.absPos.x;
    double upperBound = this.absPos.y;
    double rightBound = this.absPos.x + this.size.x;
    double lowerBound = this.absPos.y + this.size.y;

    double x = e.getX();
    double y = e.getY();

    return (x >= leftBound && x < rightBound) &&
        (y >= upperBound && y < lowerBound);
  }
}

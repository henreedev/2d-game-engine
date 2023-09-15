package engine.uitoolkit;

import engine.UIElement;
import javafx.scene.input.MouseEvent;

public class Button extends UIElement {

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

  private boolean isWithinBounds(MouseEvent e) {
    double leftBound = this.position.x;
    double upperBound = this.position.y;
    double rightBound = this.position.x + this.size.x;
    double lowerBound = this.position.y + this.size.y;

    double x = e.getX();
    double y = e.getY();

    return (x >= leftBound && x < rightBound) &&
        (y >= upperBound && y < lowerBound);
  }
}

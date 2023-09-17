package engine.uitoolkit;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends UIElement {

  protected boolean isFilled = true;
  protected boolean isRounded = false;
  // rounding will start at the last X% of a rectangle side
  protected double roundingPercent;
  protected double rotationDeg;

  public Rectangle() {
    super();
  }

  public Rectangle (Color color, boolean isFilled) {
    this.color = color;
    this.isFilled = isFilled;
  }

  public Rectangle (Color color, boolean isFilled, double roundingPercent) {
    this.color = color;
    this.isFilled = isFilled;
    this.isRounded = true;
    this.roundingPercent = roundingPercent;
  }

  public Rectangle (Color color, boolean isFilled, double roundingPercent, double rotationDeg) {
    this.color = color;
    this.isFilled = isFilled;
    this.isRounded = true;
    this.roundingPercent = roundingPercent;
    this.rotationDeg = rotationDeg;
  }

  @Override
  protected void draw(GraphicsContext g, Vec2d parentPosition) {
    Vec2d pos = this.position.plus(parentPosition);
    double roundHoz = roundingPercent / 100.0 * size.x;
    double roundVert = roundingPercent / 100.0 * size.y;

    // first, rotating the drawing canvas
    g.rotate(rotationDeg);
    g.setStroke(this.color);
    g.setFill(this.color);

    if (isFilled && !isRounded) { // filled and unrounded
      g.fillRect(pos.x, pos.y, size.x, size.y);
    } else if (isFilled) { // filled and rounded
      g.fillRoundRect(pos.x, pos.y, size.x, size.y, roundHoz, roundVert);
    } else if (isRounded) { // unfilled and rounded
      g.strokeRoundRect(pos.x, pos.y, size.x, size.y, roundHoz, roundVert);
    } else { // unfilled and unrounded
      g.strokeRect(pos.x, pos.y, size.x, size.y);
    }
  }
}

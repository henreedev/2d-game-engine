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

  @Override
  protected void onDraw(GraphicsContext g){
    Vec2d pos = getActualPos();
    double roundHoz = roundingPercent / 100.0 * size.x;
    double roundVert = roundingPercent / 100.0 * size.y;

    if (isFilled && !isRounded) { // filled and unrounded
      g.setFill(this.color);
      g.fillRect(pos.x, pos.y, size.x, size.y);

    } else if (isFilled) { // filled and rounded
      g.setFill(this.color);
      g.fillRoundRect(pos.x, pos.y, size.x, size.y, roundHoz, roundVert);
    } else if (isRounded) { // unfilled and rounded
      g.strokeRoundRect(pos.x, pos.y, size.x, size.y, roundHoz, roundVert);
    } else { // unfilled and unrounded
      g.strokeRect(pos.x, pos.y, size.x, size.y);
    }
    // Tell children to draw
    super.onDraw(g);
  }

}

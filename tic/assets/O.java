package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class O extends UIElement {

  public O(Color color) {
    super(color);
  }

  // percent of the slot length to equal hoz/vert length
  protected static double linePercent = 0.8;
  // percent of the slot length to equal line width
  protected static double widthPercent = 0.03;
  protected static double ghostOpacity = 0.5;
  private boolean isGhost;

  @Override
  protected void draw(GraphicsContext g, Vec2d parentPosition) {
    Vec2d pos = this.position.plus(parentPosition);

    double diameter = size.x * linePercent;

    double extraSpacePercent = (1 - linePercent) / 2;
    double offset = this.size.x * extraSpacePercent;

    g.setStroke(color);
    if(isGhost) {
      Color ghostColor = Color.rgb(
          (int)(color.getRed() * 255),
          (int)(color.getGreen() * 255),
          (int)(color.getBlue() * 255),
          ghostOpacity);
      g.setStroke(ghostColor);
    }
    g.setLineWidth(this.size.x * widthPercent);
    g.strokeOval(pos.x + offset, pos.y + offset, diameter, diameter);
  }

  public void setGhost(boolean isGhost) {
    this.isGhost = isGhost;
  }
}

package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class X extends UIElement {
  // percent of the slot length to equal hoz/vert length
  protected static double linePercent = 0.65;
  // percent of the slot length to equal line width
  protected static double widthPercent = 0.03;

  protected static double ghostOpacity = 0.5;
  private boolean isGhost;

  public X(Color color) {
    super(color);
  }

  @Override
  protected void draw(GraphicsContext g, Vec2d parentPosition) {
    Vec2d pos = this.position.plus(parentPosition);

    double lineLength = size.x * linePercent;

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

    //////////////////////////
    // DRAW FIRST LINE OF X (top left to bottom right)
    //////////////////////////
    double x1 = pos.x + offset;
    double y1 = pos.y + offset;
    double x2 = x1 + lineLength;
    double y2 = y1 + lineLength;

    g.strokeLine(x1, y1, x2, y2);

    //////////////////////////
    // DRAW SECOND LINE OF X (bottom left to top right)
    //////////////////////////
    double x3 = pos.x + offset;
    double y3 = pos.y + offset + lineLength;
    double x4 = x3 + lineLength;
    double y4 = y3 - lineLength;

    g.strokeLine(x3, y3, x4, y4);

  }

  public void setGhost(boolean isGhost) {
    this.isGhost = isGhost;
  }
}

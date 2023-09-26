package engine;

import engine.support.Vec2d;

public class SpaceConverter {
  protected double scale;
  protected Vec2d screenTopLeft;
  protected Vec2d gameTopLeft;

  public Vec2d gameToScreenSpace(Vec2d point) {
    double x = point.x;
    double y = point.y;

    // Minus upper left in game space
    x -= gameTopLeft.x;
    y -= gameTopLeft.y;
    // Multiply by scale
    x *= scale;
    y *= scale;
    // Add viewport upper left
    x += screenTopLeft.x;
    y += screenTopLeft.y;

    return new Vec2d(x,y);
  }

  public Vec2d screenToGameSpace(Vec2d point) {
    double x = point.x;
    double y = point.y;

    // Opposite of the steps in reverse:
    // Subtract viewport upper left
    x -= screenTopLeft.x;
    y -= screenTopLeft.y;
    // Divide by scale
    x /= scale;
    y /= scale;
    // Add upper left in game space
    x += gameTopLeft.x;
    y += gameTopLeft.y;

    return new Vec2d(x,y);
  }

}

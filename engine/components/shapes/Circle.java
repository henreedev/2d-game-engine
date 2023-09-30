package engine.components.shapes;

import engine.support.Vec2d;

public class Circle implements Shape{

  private double radius;
  private Vec2d center;

  @Override
  public boolean isColliding(Shape o) {
    return o.isColliding(this);
  }

  public boolean isCollidingAAB(AAB aab) {
    return false;
  }

  public boolean isCollidingCircle(Circle circle) {
    return false;
  }

  public boolean isCollidingPoint(Vec2d point) {
    return false;
  }

  // Getter for radius
  public double getRadius() {
    return radius;
  }

  // Setter for radius
  public void setRadius(double radius) {
    this.radius = radius;
  }

  // Getter for center
  public Vec2d getCenter() {
    return center;
  }

  // Setter for center
  public void setCenter(Vec2d center) {
    this.center = center;
  }

}

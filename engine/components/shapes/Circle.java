package engine.components.shapes;

import engine.support.Vec2d;

public class Circle implements Shape{

  private double radius;
  private Vec2d center;

  public Circle(double radius, Vec2d center) {
    this.radius = radius;
    this.center = center;
  }
  @Override
  public boolean isColliding(Shape o) {
    return o.isCollidingCircle(this);
  }

  public boolean isCollidingAAB(AAB aab) {
    return aab.isCollidingCircle(this);
  }

  public boolean isCollidingCircle(Circle circle) {
    Vec2d pos1 = this.getCenter();
    double r1 = this.getRadius();
    Vec2d pos2 = circle.getCenter();
    double r2 = circle.getRadius();
    return pos1.dist2(pos2) <= (r1 + r2) * (r1 + r2);
  }

  public boolean isCollidingPoint(Vec2d point) {
    return center.dist2(point) <= radius * radius;
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

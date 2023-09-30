package engine.components.shapes;

import engine.support.Vec2d;

public class AAB implements Shape{

  private Vec2d topLeft;
  private Vec2d size;
  private final Vec2d xAxis = new Vec2d(1,0);
  private final Vec2d yAxis = new Vec2d(0,1);

  public AAB (Vec2d topLeft, Vec2d size) {
    this.topLeft = topLeft;
    this.size = size;
  }

  @Override
  public boolean isColliding(Shape o) {
    return o.isCollidingAAB(this);
  }

  public boolean isCollidingAAB(AAB aab) {
    Interval xInt1 = new Interval(this.topLeft.projectOnto(xAxis).mag(), this.topLeft.plus(this.size).projectOnto(xAxis).mag());
    Interval yInt1 = new Interval(this.topLeft.projectOnto(yAxis).mag(), this.topLeft.plus(this.size).projectOnto(yAxis).mag());
    Interval xInt2 = new Interval(aab.topLeft.projectOnto(xAxis).mag(), aab.topLeft.plus(aab.size).projectOnto(xAxis).mag());
    Interval yInt2 = new Interval(aab.topLeft.projectOnto(yAxis).mag(), aab.topLeft.plus(aab.size).projectOnto(yAxis).mag());

    return xInt1.overlap(xInt2) && yInt1.overlap(yInt2);
  }

  public boolean isCollidingCircle(Circle circle) {
    Interval xInt = new Interval(this.topLeft.projectOnto(xAxis).mag(), this.topLeft.plus(this.size).projectOnto(xAxis).mag());
    Interval yInt = new Interval(this.topLeft.projectOnto(yAxis).mag(), this.topLeft.plus(this.size).projectOnto(yAxis).mag());

    Vec2d closestPoint = new Vec2d(clamp(xInt, circle.getCenter().x), clamp(yInt, circle.getCenter().y));
    return circle.isCollidingPoint(closestPoint);
  }

  public boolean isCollidingPoint(Vec2d point) {
    double left = this.topLeft.x;
    double right = this.topLeft.x + this.size.x;
    double top = this.topLeft.y;
    double bot = this.topLeft.y + this.size.y;
    return point.x > left && point.x < right && point.y > top && point.y < bot;
  }

  public double clamp(Interval interval, double val) {
    return Math.max(interval.min, Math.min(interval.max, val));
  }

  // Getter for topLeft
  public Vec2d getTopLeft() {
    return topLeft;
  }

  // Setter for topLeft
  public void setTopLeft(Vec2d topLeft) {
    this.topLeft = topLeft;
  }

  // Getter for size
  public Vec2d getSize() {
    return size;
  }

  // Setter for size
  public void setSize(Vec2d size) {
    this.size = size;
  }
}

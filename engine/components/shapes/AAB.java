package engine.components.shapes;

import engine.support.Vec2d;

public class AAB implements Shape{

  private Vec2d topLeft;
  private Vec2d size;

  @Override
  public boolean isColliding(Shape o) {
    return o.isCollidingAAB(this);
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

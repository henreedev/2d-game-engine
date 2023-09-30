package engine.components.shapes;

import engine.support.Vec2d;

public interface Shape {

  public boolean isColliding(Shape o);
  public boolean isCollidingAAB(AAB aab);
  public boolean isCollidingCircle(Circle circle);
  public boolean isCollidingPoint(Vec2d point);


}

package engine.systems;

import engine.GameObject;
import engine.GameSystem;
import engine.components.CollisionComponent;
import engine.components.ComponentTag;
import engine.components.TickComponent;
import engine.components.shapes.Shape;

public class CollisionSystem extends GameSystem {

  public CollisionSystem() {
    super();
  }

  @Override
  public void onTick(double deltaTime) {
    int size = this.gameObjects.size();
    for (int i = 0; i < size - 1; i++) {
        for (int j = i+1; j < size; j++) {
          GameObject go1 = this.gameObjects.get(i);
          GameObject go2 = this.gameObjects.get(j);
          CollisionComponent cc1 = (CollisionComponent) go1.getComponent(ComponentTag.COLLISION);
          CollisionComponent cc2 = (CollisionComponent) go2.getComponent(ComponentTag.COLLISION);
          Shape s1 = cc1.getShape();
          Shape s2 = cc2.getShape();

          if (s1.isColliding(s2)) {
            cc1.onCollision(go2);
            cc2.onCollision(go1);
          }

        }
    }
  }

}

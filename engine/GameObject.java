package engine;

import engine.components.Component;
import engine.components.ComponentTag;
import engine.components.TransformComponent;
import engine.support.Vec2d;
import javafx.scene.input.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameObject<T extends Enum<T>> {
  private final Map<ComponentTag, Component> componentMap;
  protected GameWorld parentWorld;
  private T objectType;
  public boolean isActive = true;

  public GameObject() {
    this.componentMap = new HashMap<>();
    addComponent(new TransformComponent(this));
  }

   public GameObject<T> addComponent(Component c) {
     this.componentMap.put(c.getTag(), c);
     return this;
   }

   public GameObject<T> removeComponent(Component c) {
     this.componentMap.remove(c.getTag());
     return this;
   }

   public void setActivity(boolean isActive) {
    this.isActive = isActive;
   }

   public Component getComponent(ComponentTag tag) {
     return this.componentMap.get(tag);
   }

   public Set<ComponentTag> getComponentTags() {
     return this.componentMap.keySet();
   }

   public TransformComponent getTransform() {
     return (TransformComponent) this.componentMap.get(ComponentTag.TRANSFORM);
   }

   public boolean isWithinTransform(MouseEvent e) {
     TransformComponent tc = this.getTransform();
     Vec2d pos = tc.getPosition();
     Vec2d size = tc.getSize();
     double leftBound = pos.x;
     double upperBound = pos.y;
     double rightBound = pos.x + size.x;
     double lowerBound = pos.y + size.y;
     SpaceConverter sc = this.parentWorld.converter;
     Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
     double x = clickPoint.x;
     double y = clickPoint.y;

     return (x >= leftBound && x < rightBound) &&
         (y >= upperBound && y < lowerBound);
   }

  public T getObjectType() {
    return objectType;
  }

  public void setObjectType(T objectType) {
    this.objectType = objectType;
  }

}

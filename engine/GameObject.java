package engine;

import engine.components.Component;
import engine.components.ComponentTag;
import engine.components.TransformComponent;
import engine.support.Vec2d;
import javafx.scene.input.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameObject {
   private final Map<ComponentTag, Component> componentMap;
   protected GameWorld parent;

   public GameObject() {
     this.componentMap = new HashMap<>();
     addComponent(new TransformComponent(this));
   }

   public GameObject addComponent(Component c) {
     this.componentMap.put(c.getTag(), c);
     return this;
   }

   public GameObject removeComponent(Component c) {
     this.componentMap.remove(c.getTag());
     return this;
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
     SpaceConverter sc = this.parent.converter;
     Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
     double x = clickPoint.x;
     double y = clickPoint.y;

     System.out.println("x = "+x+", y = "+y);
     // TODO convert x and y to game space!

     return (x >= leftBound && x < rightBound) &&
         (y >= upperBound && y < lowerBound);
   }

}

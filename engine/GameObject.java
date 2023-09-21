package engine;

import engine.components.Component;
import engine.components.ComponentTag;
import engine.components.TransformComponent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameObject {
   private Map<ComponentTag, Component> componentMap;

   public GameObject() {
     this.componentMap = new HashMap<>();
   }
   public GameObject addComponent(Component c) {
     this.componentMap.put(c.getTag(), c);
     return this;
   }

   public GameObject removeComponent(Component c) {
     this.componentMap.remove(c.getTag());
     return this;
   }

   public TransformComponent getTransform() {
     return (TransformComponent) this.componentMap.get(ComponentTag.TRANSFORM);
   }

}

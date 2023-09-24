package engine;

import engine.components.Component;
import engine.components.ComponentTag;
import engine.components.TransformComponent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameObject {
   private final Map<ComponentTag, Component> componentMap;

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

   public Component getComponent(ComponentTag tag) {
     return this.componentMap.get(tag);
   }

   public Set<ComponentTag> getComponentTags() {
     return this.componentMap.keySet();
   }

   public TransformComponent getTransform() {
     return (TransformComponent) this.componentMap.get(ComponentTag.TRANSFORM);
   }

}

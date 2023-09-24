package alc;

import engine.GameObject;
import engine.GameWorld;
import engine.components.ComponentTag;
import engine.components.GraphicsComponent;
import engine.components.TransformComponent;
import engine.components.behaviors.DrawBehavior;
import engine.support.Vec2d;
import engine.systems.GraphicsSystem;
import engine.systems.InputSystem;
import engine.systems.TickSystem;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class AlcWorld extends GameWorld {

  public AlcWorld() {
    this.graphicsSystem = new GraphicsSystem();
    this.tickSystem = new TickSystem();
    this.inputSystem = new InputSystem();
    this.gameDimensions = new Vec2d(160, 90);
    setupWorld();
  }

  private void setupWorld() {
    GameObject unit = new GameObject();
    unit.getTransform().setSize(new Vec2d(100, 100));
    unit.addComponent(new GraphicsComponent(unit, new DrawBehavior(unit) {
      @Override
      public void onDraw(GraphicsContext g) {
        TransformComponent tc = getParentTransform();
        Vec2d pos = tc.getPosition();
        Vec2d size = tc.getSize();
        g.setLineWidth(5);
        g.setStroke(Color.rgb(50, 0, 100));
        g.strokeRect(pos.x, pos.y, pos.x + size.x, pos.y + size.y);
      }
    }));
    this.addGameObject(unit);
  }
}

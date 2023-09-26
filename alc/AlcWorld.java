package alc;

import alc.assets.AlcBackground;
import alc.assets.AlcUnit;
import engine.GameObject;
import engine.GameWorld;
import engine.SpaceConverter;
import engine.components.GraphicsComponent;
import engine.components.TransformComponent;
import engine.components.behaviors.DrawBehavior;
import engine.components.behaviors.DrawLayer;
import engine.support.Vec2d;
import engine.systems.GraphicsSystem;
import engine.systems.InputSystem;
import engine.systems.TickSystem;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class AlcWorld extends GameWorld {

  public static Vec2d alcGameDimensions = new Vec2d(160, 90);

  public AlcWorld(SpaceConverter converter) {
    super(converter);
    this.graphicsSystem = new GraphicsSystem();
    this.tickSystem = new TickSystem();
    this.inputSystem = new InputSystem();
    this.gameDimensions = new Vec2d(160, 90);
    setupWorld();
  }

  private void setupWorld() {
    this.addGameObject(new AlcBackground());
    this.addGameObject(new AlcUnit());
  }
}

package alc;

import alc.assets.AlcBackground;
import alc.assets.AlcUnit;
import engine.GameWorld;
import engine.SpaceConverter;
import engine.resource.SpriteResource;
import engine.support.Vec2d;
import engine.systems.GraphicsSystem;
import engine.systems.InputSystem;
import engine.systems.TickSystem;

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

  @Override
  protected void onStartup() {
    this.spriteSheet = new SpriteResource(
        "alc/assets/spritesheet.png", 32, 32, 0
    );
  }
}

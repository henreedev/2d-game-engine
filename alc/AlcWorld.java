package alc;

import alc.assets.AlcBackground;
import alc.assets.AlcType;
import alc.assets.AlcUnit;
import engine.GameWorld;
import engine.SpaceConverter;
import engine.resource.SpriteResource;
import engine.support.Vec2d;

public class AlcWorld extends GameWorld {

  public static Vec2d alcGameDimensions = new Vec2d(160, 90);

  public AlcWorld(SpaceConverter converter) {
    super(converter);
    this.gameDimensions = new Vec2d(160, 90);
    setupWorld();
  }

  private void setupWorld() {
    this.addGameObject(new AlcBackground());
    this.addGameObject(new AlcUnit(AlcType.LIGHT_BLUE_MUSHROOM,
                                   new Vec2d(140, 15),
                                   new Vec2d(10, 10)));
    this.addGameObject(new AlcUnit(AlcType.DARK_BLUE_MUSHROOM,
                                   new Vec2d(140, 30),
                                   new Vec2d(10, 10)));
    this.addGameObject(new AlcUnit(AlcType.PURPLE_FLOWER,
                                   new Vec2d(140, 45),
                                   new Vec2d(10, 10)));
    this.addGameObject(new AlcUnit(AlcType.PURPLE_PLANT,
                                   new Vec2d(140, 60),
                                   new Vec2d(10, 10)));
    this.addGameObject(new AlcUnit(AlcType.TRASH,
        new Vec2d(20, 35),
        new Vec2d(20, 20)));

  }

  @Override
  protected void onStartup() {
    this.spriteSheet = new SpriteResource(
        "alc/assets/spritesheet.png", 32, 32, 0
    );
  }
}

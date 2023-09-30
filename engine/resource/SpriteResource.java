package engine.resource;

import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpriteResource extends Resource {

  private Image spriteSheet;
  private final int spriteWidth;
  private final int spriteHeight;
  private final int padding;

  public SpriteResource(String relativeFilepath, int spriteWidth, int spriteHeight, int padding) {
    super(relativeFilepath);
    this.spriteWidth = spriteWidth;
    this.spriteHeight = spriteHeight;
    this.padding = padding;
  }

  @Override
  protected void loadResource(String relativeFilepath) {
    this.spriteSheet = new Image("file:" + relativeFilepath);
  }

  public void drawSprite(GraphicsContext g, Vec2d indexCoords, Vec2d pos, Vec2d size) {
    double x = (spriteWidth + padding) * indexCoords.x + padding;
    double y = (spriteHeight + padding) * indexCoords.y + padding;
    g.drawImage(spriteSheet, x, y, spriteWidth, spriteHeight,
                pos.x, pos.y, size.x, size.y);
//    g.drawImage(spriteSheet, x, y);
  }
}

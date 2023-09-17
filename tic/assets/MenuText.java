package tic.assets;

import engine.support.Vec2d;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MenuText extends Text {

  private double widthPercent = 0.7;
  private double heightPercent = 0.2;
  public MenuText(String text, Font font, Color color,
      TextAlignment textAlignment) {
    super(text, font, color, textAlignment);
  }

  @Override
  protected void resize(Vec2d newSize) {
    this.size = new Vec2d(newSize.x * widthPercent, newSize.y * heightPercent);
    this.fontSize = this.size.x * 1.5 / this.text.length();
  }

  @Override
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d(newSize.x * 0.5, newSize.y * 0.2);
  }
}

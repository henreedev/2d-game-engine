package tic.assets;

import engine.support.Vec2d;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TimerText extends Text {

  protected static double widthPercent = 0.85;
  protected static double heightPercent = 0.05;
  protected static double sizeAdjustment = 1.8;

  public TimerText(String text, Font font, Color color, boolean isFilled, double strokeWidth) {
    super(text, font, color, isFilled, strokeWidth);
  }

  @Override
  protected void resize(Vec2d newSize) {
    this.size = new Vec2d(newSize.x * widthPercent, newSize.y * heightPercent);
    this.fontSize = this.size.x / this.text.length() * sizeAdjustment;
  }

  @Override
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d(newSize.x * (1 - widthPercent) / 2, newSize.y / 2);
  }
}

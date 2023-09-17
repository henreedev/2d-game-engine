package tic.assets;

import static tic.TicScreen.statusMessage;
import static tic.TicScreen.whoWon;
import static tic.TicScreen.whoseTurn;
import static tic.assets.TimerText.heightPercent;
import static tic.assets.TimerText.sizeAdjustment;
import static tic.assets.TimerText.widthPercent;

import engine.Screen;
import engine.support.Vec2d;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class TurnText extends Text {

  public TurnText(String text, Font font, Color color,
      TextAlignment textAlignment) {
    super(text, font, color, textAlignment);
  }

  @Override
  protected void resize(Vec2d newSize) {
    this.size = new Vec2d(newSize.x * widthPercent, newSize.y * heightPercent);
    this.fontSize = this.size.x / this.text.length() * sizeAdjustment;
  }

  @Override
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d(newSize.x * (1 - widthPercent) / 2, newSize.y / 3);
  }

  @Override
  protected void tick(double deltaTime) {
    if (whoWon.equals("")) {
      this.text = "It's " + whoseTurn + "'s turn!";
    } else {
      this.text = statusMessage;
    }
  }
}

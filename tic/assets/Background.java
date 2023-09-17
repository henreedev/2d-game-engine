package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import engine.uitoolkit.Rectangle;
import engine.uitoolkit.Text;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tic.TicScreen;

public class Background extends Rectangle {

  private final Color xTurnColor = Color.rgb(50, 50, 128);
  private final Color oTurnColor = Color.rgb(128, 50, 0);
  public Background() {
    super(Color.BLACK, true); // will be immediately replaced
    this.uiElements.add(new InfoContainer());
  }

  @Override
  protected void tick(double deltaTime) {
    if(TicScreen.whoseTurn.equals("X")) {
      this.setColor(xTurnColor);
    } else {
      this.setColor(oTurnColor);
    }
  }
}

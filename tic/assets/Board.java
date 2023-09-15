package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import engine.uitoolkit.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board extends Rectangle {

  // what % of the screen height to remove from the board's length
  private final double offsetFactor = 0.05;

  public Board() {
    super(Color.BLACK, true, 10.0);
    for(int i = 0; i < 9; i++) {
      this.uiElements.add(new BoardSlot(i));
    }
  }

  @Override
  protected void resize(Vec2d newSize) {
    double length = newSize.y - newSize.y * offsetFactor;
    this.size = new Vec2d(length, length);
  }

  @Override
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d((newSize.x - newSize.y) / 2, newSize.y * offsetFactor / 2);
  }


}

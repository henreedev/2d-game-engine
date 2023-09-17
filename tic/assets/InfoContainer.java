package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class InfoContainer extends UIElement {

  public InfoContainer() {
    super();
    this.uiElements.add(new Timer());
    this.uiElements.add(new TurnText("It's X's turn!", Font.font("Times New Roman", 100), Color.rgb(200, 200 ,200),
        TextAlignment.LEFT));
  }
  @Override
  protected void resize(Vec2d newSize) {
    double ySize = newSize.y;
    double xSize = (newSize.x - ySize) / 2;
    this.size = new Vec2d(xSize, ySize);
  }
}

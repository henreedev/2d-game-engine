package tic.assets;

import engine.uitoolkit.Rectangle;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Menu extends Rectangle {

  public Menu() {
    super(Color.rgb(50, 50, 50), true);
    this.uiElements.add(new StartButton(new StartButtonBehavior()));
    this.uiElements.add(new MenuText("Tic-Tac-Toe", Font.font("Times New Roman"),
        Color.rgb(200, 200, 200), TextAlignment.CENTER));
    this.uiElements.add(new Text("Press r to toggle this menu", Font.font("Times New Roman"),
        Color.rgb(200, 200, 200), TextAlignment.CENTER)
        .setPositionScalars(0.5, 0.75).setSizeScalar(0.75));
  }
}

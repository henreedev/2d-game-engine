package tic.assets;

import engine.support.Vec2d;
import engine.uitoolkit.Button;
import engine.uitoolkit.ButtonBehavior;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class StartButton extends Button {

  private Text startButtonText;

  public StartButton(ButtonBehavior behavior) {
    super(behavior);
    this.startButtonText = new Text("Start New Game", Font.font("Times New Roman"),
        Color.rgb(200, 200, 200), TextAlignment.CENTER);
    this.uiElements.add(startButtonText);
  }

  @Override
  protected void resize(Vec2d newSize) {
    // middle 20% of screen
    double screenPercent = 0.2;
    this.size = new Vec2d(newSize.x * 0.2, newSize.y * 0.2);


  }
}

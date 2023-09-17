package tic.assets;

import engine.support.Vec2d;
import engine.uitoolkit.Button;
import engine.uitoolkit.ButtonBehavior;
import engine.uitoolkit.Rectangle;
import engine.uitoolkit.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class StartButton extends Button {

  private Text startButtonText;
  private double screenPercent = 0.2;

  public StartButton(ButtonBehavior behavior) {
    super(behavior);
    this.startButtonText = new Text("Start New Game", Font.font("Times New Roman"),
        Color.rgb(200, 200, 200), TextAlignment.CENTER);
    this.uiElements.add(new Rectangle(Color.DARKBLUE, true, 30));
    this.uiElements.add(startButtonText);
  }

  @Override
  protected void resize(Vec2d newSize) {
    // middle 20% of screen
    this.size = new Vec2d(newSize.x * screenPercent, newSize.y * screenPercent);
  }

  @Override
  protected void reposition(Vec2d newSize) {
    double positionMultiplier = (0.5 - screenPercent / 2);
    this.position = new Vec2d(newSize.x * positionMultiplier, newSize.y * positionMultiplier);
  }
}

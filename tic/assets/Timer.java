package tic.assets;

import engine.UIElement;
import engine.uitoolkit.Text;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tic.TicScreen;

public class Timer extends UIElement {

  private final Text text;
  private static double turnDuration = 7.5;
  private static double timeVal = turnDuration;
  private final String preTimeText = "Time remaining: ";


  public Timer() {
    super();
    Font textFont = Font.font("Times New Roman", 100);
    Color textColor = Color.rgb(200, 200, 200);
    this.text = new TimerText(preTimeText, textFont, textColor, true, 0);
    this.uiElements.add(text);
  }

  @Override
  protected void tick(double deltaTime) {
    if (TicScreen.whoWon.equals("")) {
      timeVal = adjustTimeVal(deltaTime);
      DecimalFormat df = new DecimalFormat("#.##");
      String formattedNumber = df.format(timeVal);
      this.text.setText(preTimeText + formattedNumber);
    }
  }

  public static double adjustTimeVal(double deltaTime) {
    if(deltaTime < 1.0) { // avoid glitch where first deltaTime is 9000+
      timeVal -= deltaTime;
    }
    if(timeVal < 0.0) {
      resetTimeVal();
      TicScreen.swapTurn();
    }
    return timeVal;
  }

  public static void resetTimeVal() {
    timeVal = turnDuration;
  }
}

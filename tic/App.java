package tic;

import engine.Application;
import engine.support.Vec2d;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * This is your Tic-Tac-Toe top-level, App class.
 * This class will contain every other object in your game.
 */
public class App extends Application {

  public App(String title) {
    super(title);
    TicScreen ticScreen = new TicScreen();
    // Add screens to this Application here:
    screens.add(ticScreen);
  }

  public App(String title, Vec2d windowSize, boolean debugMode, boolean fullscreen) {
    super(title, windowSize, debugMode, fullscreen);
  }

  @Override
  protected void onKeyPressed(KeyEvent e) {
    if (e.getCode() == KeyCode.ESCAPE) {
      onShutdown();
      Platform.exit();
      System.exit(0);
    }
    super.onKeyPressed(e);
  }

}

package alc;

import engine.Application;
import engine.support.Vec2d;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import tic.TicScreen;
import tic.assets.MenuScreen;

/**
 * This is your Tic-Tac-Toe top-level, App class.
 * This class will contain every other object in your game.
 */
public class App extends Application {

  private AlcScreen alcScreen;

  public App(String title) {
    super(title);
    alcScreen = new AlcScreen();
    // Add screens to this Application here:
    screens.add(alcScreen);
  }

  public App(String title, Vec2d windowSize, boolean debugMode, boolean fullscreen) {
    super(title, windowSize, debugMode, fullscreen);
  }


  @Override
  public void swapScreens() {

  }

  @Override
  protected void onKeyPressed(KeyEvent e) {
    if (e.getCode() == KeyCode.ESCAPE) {
      onShutdown();
      Platform.exit();
      System.exit(0);
    } else if (e.getCode() == KeyCode.R) {
//      swapScreens();
    }
    super.onKeyPressed(e);
  }

}

package tic;

import engine.Application;
import engine.support.Vec2d;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import tic.assets.MenuScreen;


/**
 * This is your Tic-Tac-Toe top-level, App class.
 * This class will contain every other object in your game.
 */
public class App extends Application {

  private TicScreen ticScreen;
  private MenuScreen menuScreen;

  public App(String title) {
    super(title);
    ticScreen = new TicScreen();
    menuScreen = new MenuScreen();
    // Add screens to this Application here:
    screens.add(ticScreen);
    screens.add(menuScreen);
    // start with menu displayed
    menuScreen.setActivity(false);
  }

  public App(String title, Vec2d windowSize, boolean debugMode, boolean fullscreen) {
    super(title, windowSize, debugMode, fullscreen);
  }

  @Override
  public void swapScreens() {
    ticScreen.setActivity(!ticScreen.isActive());
    menuScreen.setActivity(!menuScreen.isActive());
  }

  @Override
  protected void onKeyPressed(KeyEvent e) {
    if (e.getCode() == KeyCode.ESCAPE) {
      onShutdown();
      Platform.exit();
      System.exit(0);
    } else {

//    } else if (e.getCharacter().charAt(0) == 'r' || e.getCharacter().charAt(0) == 'R') {
      System.out.println("swapping");
      swapScreens();
    }
    super.onKeyPressed(e);
  }

}

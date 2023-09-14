package tic;

import engine.Application;
import engine.support.Vec2d;
import java.util.ArrayList;


/**
 * This is your Tic-Tac-Toe top-level, App class.
 * This class will contain every other object in your game.
 */
public class App extends Application {

  public App(String title) {
    super(title);
    TicScreen ticScreen = new TicScreen();
    this.screens = new ArrayList<>();
    // Add UIElements to this screen here:
    screens.add(ticScreen);
    // Link each UIElement to this screen:
    setChildrenParent();
  }

  public App(String title, Vec2d windowSize, boolean debugMode, boolean fullscreen) {
    super(title, windowSize, debugMode, fullscreen);
  }

}

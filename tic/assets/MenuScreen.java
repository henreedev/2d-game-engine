package tic.assets;

import engine.Screen;
import engine.UIElement;
import tic.TicScreen;

public class MenuScreen extends Screen {

  public static boolean shouldStartGame = false;

  public MenuScreen() {
    super();
    uiElements.add(new Menu());
  }

  @Override
  protected void tick(double deltaTime) {
    if(shouldStartGame) {
      TicScreen.resetGameData();
      this.parent.swapScreens();
      shouldStartGame = false;
    }
  }
}

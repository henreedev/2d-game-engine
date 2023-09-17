package tic.assets;

import engine.Screen;
import engine.UIElement;

public class MenuScreen extends Screen {
  public MenuScreen() {
    super();
    uiElements.add(new Menu());
  }
}

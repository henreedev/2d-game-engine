package alc;

import engine.GameWorld;
import engine.Screen;
import engine.Viewport;

public class AlcScreen extends Screen {

  public AlcScreen() {
    super();
    this.viewport = new Viewport();
    this.uiElements.add(this.viewport); // to receive calls like other UIElements
    this.addGameWorld(new AlcWorld());
  }
}

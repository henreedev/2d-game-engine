package alc;

import engine.GameWorld;
import engine.systems.GraphicsSystem;
import engine.systems.InputSystem;
import engine.systems.TickSystem;

public class AlcWorld extends GameWorld {

  public AlcWorld() {
    this.graphicsSystem = new GraphicsSystem();
    this.tickSystem = new TickSystem();
    this.inputSystem = new InputSystem();
  }
}

package alc;

import engine.GameWorld;
import engine.Screen;
import engine.SpaceConverter;
import engine.Viewport;
import javafx.scene.canvas.GraphicsContext;

public class AlcScreen extends Screen {

  public AlcScreen() {
    super();
    SpaceConverter converter = new SpaceConverter();
    Viewport viewport = new Viewport(converter, new AlcWorld(converter));
    this.uiElements.add(viewport); // to receive calls like other UIElements
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    g.fillRect(0, 0, g.getCanvas().getWidth(), g.getCanvas().getHeight());
    super.onDraw(g);
  }
}

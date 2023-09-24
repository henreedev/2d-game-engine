package alc;

import engine.GameWorld;
import engine.Screen;
import engine.Viewport;
import javafx.scene.canvas.GraphicsContext;

public class AlcScreen extends Screen {

  public AlcScreen() {
    super();
    this.viewport = new Viewport();
    this.uiElements.add(this.viewport); // to receive calls like other UIElements
    this.addGameWorld(new AlcWorld());
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    g.fillRect(0, 0, g.getCanvas().getWidth(), g.getCanvas().getHeight());
    super.onDraw(g);
  }
}

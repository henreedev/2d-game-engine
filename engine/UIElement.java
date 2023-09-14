package engine;

import engine.support.Vec2d;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class UIElement extends Screen {

  // Member variables
  protected Screen parentScreen;
  protected List<Color> colors;


  public void setParent(Screen parentScreen) {
    this.parentScreen = parentScreen;
  }
}

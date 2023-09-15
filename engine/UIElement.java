package engine;

import engine.support.Vec2d;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public abstract class UIElement extends Screen {

  // Member variables
  protected Screen parentScreen;
  protected Color color;

  public UIElement() {
    super();
    this.color = Color.BLACK; // default color
  }

  public void setParent(Screen parentScreen) {
    this.parentScreen = parentScreen;
  }

  protected Vec2d getActualPos() {
    return this.position.plus(parentScreen.getPosition());
  }

}

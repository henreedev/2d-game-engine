package engine;

import engine.GameWorld;
import engine.UIElement;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;

public class Viewport extends UIElement {
  protected List<Affine> affines;
  protected Affine testAffine;
  protected List<GameWorld> gameWorlds;
  protected int activeGameWorld = 0;

  public void addGameWorld(GameWorld gameWorld) {
    this.gameWorlds.add(gameWorld);
    Affine transform = new Affine();
    this.affines.add(transform);
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    g.setTransform(affines.get(activeGameWorld));
    GameWorld gw = gameWorlds.get(activeGameWorld);
    gw.onDraw(g);
  }
}

package engine;

import engine.support.Vec2d;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Affine;

public class Viewport extends UIElement {
  protected List<Affine> transforms;
  protected List<GameWorld> gameWorlds;
  protected List<Double> scaleFactors;
  protected List<Vec2d> translations;
  protected int activeGameWorld = 0;
  protected double zoomFactor = 1.01; // multiply or divide by this on each mouse scroll

  public Viewport() {
    super();
    this.transforms = new ArrayList<>();
    this.gameWorlds = new ArrayList<>();
    this.scaleFactors = new ArrayList<>();
    this.translations = new ArrayList<>();
  }

  public void addGameWorld(GameWorld gameWorld) {
    this.gameWorlds.add(gameWorld);
    this.scaleFactors.add(1.0);
    this.translations.add(new Vec2d(0.0, 0.0));
    this.transforms.add(generateAffine());
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    g.setTransform(transforms.get(activeGameWorld));
    GameWorld gw = gameWorlds.get(activeGameWorld);
    gw.onDraw(g);
    System.out.println(g.getTransform());
  }

  @Override
  protected void onDraw(GraphicsContext g, Vec2d parentPosition) {
    onDraw(g);
  }

  private Affine generateAffine() {
    Affine transform = new Affine();
    double currentScale = this.scaleFactors.get(activeGameWorld);
    Vec2d currentTranslation = this.translations.get(activeGameWorld);
    transform.appendScale(currentScale, currentScale);
    transform.appendTranslation(currentTranslation.x, currentTranslation.y);
    return transform;
  }

  private void updateAffine() {
    this.transforms.set(activeGameWorld, generateAffine());
  }

  private void onZoom(boolean isUpScroll) {
    if (isUpScroll) {
      this.scaleFactors.set(activeGameWorld, this.scaleFactors.get(activeGameWorld) * zoomFactor);
    } else {
      this.scaleFactors.set(activeGameWorld, this.scaleFactors.get(activeGameWorld) / zoomFactor);
    }
    updateAffine();
  }

  @Override
  protected void onMouseWheelMoved(ScrollEvent e) {
    System.out.println(this.scaleFactors.get(activeGameWorld));
    onZoom(e.getDeltaY() > 0);
    super.onMouseWheelMoved(e);
  }

  @Override
  protected void onResize(Vec2d newSize) {

  }
}

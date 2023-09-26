package engine;

import engine.support.Vec2d;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Affine;

public class Viewport extends UIElement {
  protected List<Affine> transforms;
  protected List<GameWorld> gameWorlds;
  protected List<Double> scaleFactors;
  protected List<Vec2d> translations;
  protected int activeGameWorld = 0;
  // TODO make all three variables below into lists like above
  protected double zoomFactor = 1.01; // multiply or divide by this on each mouse scroll
  protected double zoomScalar = 1.0; // current zoom level
  protected double screenToGameRatio;
  protected Vec2d gamePos; // in game space
  protected double clipWidth;
  protected double clipHeight;
  private SpaceConverter converter;

  public Viewport(SpaceConverter converter) {
    super();
    this.converter = converter;
    converter.screenTopLeft = new Vec2d(0, 0);
    converter.gameTopLeft = new Vec2d(0, 0);
    this.transforms = new ArrayList<>();
    this.gameWorlds = new ArrayList<>();
    this.scaleFactors = new ArrayList<>();
    this.translations = new ArrayList<>();
  }

  public void addGameWorld(GameWorld gameWorld) {
    this.gamePos = new Vec2d(0, 0);
    this.screenToGameRatio = this.size.x / gameWorld.gameDimensions.x;

    this.gameWorlds.add(gameWorld);
    this.scaleFactors.add(screenToGameRatio);
    this.translations.add(new Vec2d(0.0, 0.0));
    this.transforms.add(generateAffine());
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    // set up clipping

    // apply game affine and draw game
    g.setTransform(transforms.get(activeGameWorld));
    GameWorld gw = gameWorlds.get(activeGameWorld);
    gw.onDraw(g);
  }

  @Override
  protected void onDraw(GraphicsContext g, Vec2d parentPosition) {
    onDraw(g);
  }

  protected void onTick(double deltaTime) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onTick(deltaTime);
    }
    super.onTick(deltaTime);
  }

  protected void onKeyTyped(KeyEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onKeyTyped(e);
    }
    super.onKeyTyped(e);
  }

  protected void onKeyPressed(KeyEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onKeyPressed(e);
    }
    super.onKeyPressed(e);
  }

  protected void onKeyReleased(KeyEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onKeyReleased(e);
    }
    super.onKeyReleased(e);
  }

  protected void onMouseClicked(MouseEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onMouseClicked(e);
    }
    super.onMouseClicked(e);
  }

  protected void onMousePressed(MouseEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onMousePressed(e);
    }
    super.onMousePressed(e);
  }

  protected void onMouseReleased(MouseEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onMouseReleased(e);
    }
    super.onMouseReleased(e);
  }

  protected void onMouseDragged(MouseEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onMouseDragged(e);
    }
    super.onMouseDragged(e);
  }

  protected void onMouseMoved(MouseEvent e) {
    GameWorld gw = gameWorlds.get(activeGameWorld);
    if (gw != null) {
      gw.onMouseMoved(e);
    }
    super.onMouseMoved(e);
  }

  private Affine generateAffine() {
    Affine transform = new Affine();
    double currentScale = this.scaleFactors.get(activeGameWorld);
    Vec2d currentTranslation = this.translations.get(activeGameWorld);
    transform.appendTranslation(-currentTranslation.x, -currentTranslation.y); // minus game upperleft
    transform.appendScale(currentScale, currentScale); // times scale
    return transform;
  }

  private void updateAffine() {
    this.transforms.set(activeGameWorld, generateAffine());
  }

  private void onZoom(boolean isUpScroll) {
    if (isUpScroll) {
      zoomScalar *= zoomFactor;
    } else {
      zoomScalar /= zoomFactor;
    }
    updateScale();
    updateAffine();
  }

  @Override
  protected void onMouseWheelMoved(ScrollEvent e) {
    System.out.println(this.scaleFactors.get(activeGameWorld));
    onZoom(e.getDeltaY() > 0);
    super.onMouseWheelMoved(e);
  }

  protected void updateScale() {
    this.scaleFactors.set(activeGameWorld, screenToGameRatio * zoomScalar);
    converter.scale = screenToGameRatio * zoomScalar;
  }
  // TODO add panning, take everything out of list form

  @Override
  protected void resize(Vec2d newSize) {
    this.size = newSize;
    // set clipping bounds for what's drawn
    double idealAspectRatio = 16.0 / 9.0;
    double actualAspectRatio = newSize.x / newSize.y;
    double clipWidth;
    double clipHeight;
    if (actualAspectRatio < idealAspectRatio) {
      clipWidth = newSize.x;
      clipHeight = clipWidth / idealAspectRatio;
    } else {
      clipHeight = newSize.y;
      clipWidth = clipHeight * idealAspectRatio;
    }
    this.clipWidth = clipWidth;
    this.clipHeight = clipHeight;
    screenToGameRatio = clipWidth / this.gameWorlds.get(activeGameWorld).gameDimensions.x;
    updateScale();
    updateAffine();
  }
}

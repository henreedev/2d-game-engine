package engine;

import engine.support.Vec2d;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Affine;

public class Viewport extends UIElement {
  protected Affine transform;
  protected GameWorld gameWorld;
  private Vec2d gameWorldDims;
  protected double scaleFactor;
  protected Vec2d translation;
  protected double zoomFactor = 1.005; // multiply or divide by this on each mouse scroll
  protected double zoomScalar = 1.0; // current zoom level
  protected double screenToGameRatio; // size difference between game and screen horizontally (ratio)
  protected Vec2d gamePos; // in game space
  protected double clipWidth;
  protected double clipHeight;
  private final SpaceConverter converter;
  private enum KeyPressed {W, A, S, D, NONE};
  private KeyPressed currentPanDirection;


  public Viewport(SpaceConverter converter, GameWorld gameWorld) {
    super();
    this.converter = converter;
    converter.screenTopLeft = new Vec2d(0, 0);
    converter.gameTopLeft = new Vec2d(0, 0);

    this.gamePos = new Vec2d(0, 0);
    this.screenToGameRatio = this.size.x / gameWorld.gameDimensions.x;

    this.gameWorld = gameWorld;
    gameWorldDims = gameWorld.gameDimensions;
    this.scaleFactor = screenToGameRatio;
    this.translation = new Vec2d(0.0, 0.0);
    this.transform = generateAffine();
  }

  @Override
  protected void onDraw(GraphicsContext g) {
    // apply game affine and draw game
    g.setTransform(transform);
    gameWorld.onDraw(g);
  }

  @Override
  protected void onDraw(GraphicsContext g, Vec2d parentPosition) {
    onDraw(g);
  }

  protected void onTick(double deltaTime) {
      gameWorld.onTick(deltaTime);
    super.onTick(deltaTime);
  }

  protected void onKeyTyped(KeyEvent e) {
      gameWorld.onKeyTyped(e);
    super.onKeyTyped(e);
  }

  protected void startPanning(KeyPressed keyPressed) {
    this.currentPanDirection = keyPressed;
  }

  protected void stopPanning() {
    this.currentPanDirection = KeyPressed.NONE;
  }

  protected void pan(double deltaTime) {
    Vec2d panTranslation;
    double panIncrement = 100.0;
    double panAmount = deltaTime * panIncrement;
    if (currentPanDirection == KeyPressed.W) {
      panTranslation = new Vec2d(0, -panAmount);
    } else if (currentPanDirection == KeyPressed.A) {
      panTranslation = new Vec2d(-panAmount, 0);
    } else if (currentPanDirection == KeyPressed.S) {
      panTranslation = new Vec2d(0, panAmount);
    } else if (currentPanDirection == KeyPressed.D) {
      panTranslation = new Vec2d(panAmount, 0);
    } else {
      panTranslation = new Vec2d(0, 0);
    }
    translate(panTranslation);

    updateAffine();
  }

  @Override
  protected void tick(double deltaTime) {
    pan(deltaTime);
  }

  protected void onKeyPressed(KeyEvent e) {
    if (e.getCode() == KeyCode.W) {
      startPanning(KeyPressed.W);
    } else if (e.getCode() == KeyCode.A) {
      startPanning(KeyPressed.A);
    }else if (e.getCode() == KeyCode.S) {
      startPanning(KeyPressed.S);
    }else if (e.getCode() == KeyCode.D) {
      startPanning(KeyPressed.D);
    }
      gameWorld.onKeyPressed(e);
    super.onKeyPressed(e);
  }

  protected void onKeyReleased(KeyEvent e) {
    stopPanning();
      gameWorld.onKeyReleased(e);
    super.onKeyReleased(e);
  }

  protected void onMouseClicked(MouseEvent e) {
      gameWorld.onMouseClicked(e);
    super.onMouseClicked(e);
  }

  protected void onMousePressed(MouseEvent e) {
      gameWorld.onMousePressed(e);
    super.onMousePressed(e);
  }

  protected void onMouseReleased(MouseEvent e) {
      gameWorld.onMouseReleased(e);
    super.onMouseReleased(e);
  }

  protected void onMouseDragged(MouseEvent e) {
      gameWorld.onMouseDragged(e);
    super.onMouseDragged(e);
  }

  protected void onMouseMoved(MouseEvent e) {
    gameWorld.onMouseMoved(e);
    super.onMouseMoved(e);
  }

  private Affine generateAffine() {
    Affine transform = new Affine();
    transform.appendTranslation(-translation.x * scaleFactor, -translation.y * scaleFactor); // minus game upperleft
    transform.appendScale(scaleFactor, scaleFactor); // times scale
    return transform;
  }

  private void updateAffine() {
    this.transform = generateAffine();
  }

  private void onZoom(boolean isDownScroll) {
    double oldScale = scaleFactor;

    if (isDownScroll) {
      // zoom in
      double maxZoomFactor = 2.0;
      zoomScalar *= zoomFactor;
      if (zoomScalar > maxZoomFactor) zoomScalar = maxZoomFactor;
    } else { // up scroll
      // zoom out
      double minZoomFactor = 1.0;
      zoomScalar /= zoomFactor;
      if (zoomScalar < 1.0) zoomScalar = minZoomFactor;
    }
    updateScale();

    double scaleDifference = scaleFactor - oldScale;
    translate(new Vec2d((scaleDifference * gameWorldDims.x / 4), (scaleDifference * gameWorldDims.y / 4)));

    updateAffine();
  }


  @Override
  protected void onMouseWheelMoved(ScrollEvent e) {
    onZoom(e.getDeltaY() > 0);
    super.onMouseWheelMoved(e);
  }

  protected void updateScale() {
    this.scaleFactor = screenToGameRatio * zoomScalar;
    converter.scale = screenToGameRatio * zoomScalar;
  }

  protected void translate(Vec2d translation) {
    Vec2d res = this.translation.plus(translation);
    this.translation = this.translation.plus(translation.pdiv(new Vec2d(screenToGameRatio, screenToGameRatio)));
    converter.gameTopLeft = this.translation;
  }

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
    screenToGameRatio = clipWidth / this.gameWorld.gameDimensions.x;

    updateScale();
    updateAffine();
  }
}

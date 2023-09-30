package engine;

import engine.components.ComponentTag;
import engine.resource.SpriteResource;
import engine.support.Vec2d;
import engine.systems.CollisionSystem;
import engine.systems.GraphicsSystem;
import engine.systems.InputSystem;
import engine.systems.TickSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class GameWorld {
  /* add:
   * an addGameObject(GameObject gObj) method that adds the gameObject to all relevant
   *  Systems based on its components
   * a removal queue of GameObjects, and a removeGameObject(GameObject gObj) function that adds the
   *  gameObject instance to that list. onTick and onDraw should delete objects in the queue from
   *  their respective System.
   * a public input map from string ("w", "W", "esc", etc.) to boolean (currently input or not).
   */
  protected GameSystem graphicsSystem;
  protected GameSystem tickSystem;
  protected GameSystem inputSystem;
  protected GameSystem collisionSystem;
  protected Vec2d gameDimensions;
  public SpaceConverter converter;
  private final List<GameObject<?>> creationQueue;
  private final List<GameObject<?>> deletionQueue;
  public SpriteResource spriteSheet;

  public GameWorld(SpaceConverter converter) {
    this.converter = converter;

    this.creationQueue = new ArrayList<>();
    this.deletionQueue = new ArrayList<>();

    this.graphicsSystem = new GraphicsSystem();
    this.tickSystem = new TickSystem();
    this.inputSystem = new InputSystem();
    this.collisionSystem = new CollisionSystem();
  }

  public void addGameObject(GameObject<?> gObj) {
    creationQueue.add(gObj);
  }

  public void removeGameObject(GameObject<?> gObj) {
    deletionQueue.add(gObj);
  }

  protected void onDraw(GraphicsContext g) {
    graphicsSystem.onDraw(g);
  }

  private void flushCreationQueue() {
    for (GameObject<?> gObj : creationQueue) {
      // CREATE GAMEOBJ
      Set<ComponentTag> componentTags = gObj.getComponentTags();
      if (componentTags.contains(ComponentTag.GRAPHICS)) {
        this.graphicsSystem.addGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.TICK)) {
        this.tickSystem.addGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.INPUT)) {
        this.inputSystem.addGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.COLLISION)) {
        this.collisionSystem.addGameObject(gObj);
      }
      gObj.parentWorld = this;
    }
    creationQueue.clear();
  }

  private void flushDeletionQueue() {
    for (GameObject<?> gObj : deletionQueue) {
      //  GAMEOBJ
      Set<ComponentTag> componentTags = gObj.getComponentTags();
      if (componentTags.contains(ComponentTag.GRAPHICS)) {
        this.graphicsSystem.removeGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.TICK)) {
        this.tickSystem.removeGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.INPUT)) {
        this.inputSystem.removeGameObject(gObj);
      }
      if (componentTags.contains(ComponentTag.COLLISION)) {
        this.collisionSystem.removeGameObject(gObj);
      }
    }
    deletionQueue.clear();
  }

  protected void onTick(double deltaTime) {
    flushCreationQueue();
    flushDeletionQueue();
    tickSystem.onTick(deltaTime);
    collisionSystem.onTick(deltaTime);
  }

  /**
   * Called when a key is typed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyTyped(KeyEvent e) {
    inputSystem.onKeyTyped(e);
  }

  /**
   * Called when a key is pressed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyPressed(KeyEvent e) {
    inputSystem.onKeyPressed(e);
  }

  /**
   * Called when a key is released.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyReleased(KeyEvent e) {
    inputSystem.onKeyReleased(e);
  }

  /**
   * Called when the mouse is clicked.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseClicked(MouseEvent e) {
    inputSystem.onMouseClicked(e);
  }

  /**
   * Called when the mouse is pressed.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMousePressed(MouseEvent e) {
    inputSystem.onMousePressed(e);
  }

  /**
   * Called when the mouse is released.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseReleased(MouseEvent e) {
    inputSystem.onMouseReleased(e);
  }

  /**
   * Called when the mouse is dragged.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseDragged(MouseEvent e) {
    inputSystem.onMouseDragged(e);
  }

  /**
   * Called when the mouse is moved.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseMoved(MouseEvent e) {
    inputSystem.onMouseMoved(e);
  }

  /**
   * Called when the mouse wheel is moved.
   * @param e		an FX {@link ScrollEvent} representing the input event.
   */
  protected void onMouseWheelMoved(ScrollEvent e) {
    inputSystem.onMouseWheelMoved(e);
  }

  /**
   * Called when the app is shutdown.
   */
  protected void onShutdown() {}

  /**
   * Called when the app is starting up.
   */
  protected void onStartup() {}
}

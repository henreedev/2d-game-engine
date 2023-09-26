package engine;

import engine.components.ComponentTag;
import engine.support.Vec2d;
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
  protected Vec2d gameDimensions;
  public SpaceConverter converter;
  private List<GameObject> creationQueue;

  public GameWorld(SpaceConverter converter) {
    this.converter = converter;
    this.creationQueue = new ArrayList<>();
  }

  public void addGameObject(GameObject gObj) {
    creationQueue.add(gObj);
  }

  protected void onDraw(GraphicsContext g) {
    if (graphicsSystem != null) {
      graphicsSystem.onDraw(g);
    }
  }

  private void flushCreationQueue() {
    for (GameObject gObj : creationQueue) {
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
      gObj.parent = this;
    }
    creationQueue.clear();
  }

  protected void onTick(double deltaTime) {
    flushCreationQueue();
    if (tickSystem != null) {
      tickSystem.onTick(deltaTime);
    }
  }

  /**
   * Called when a key is typed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyTyped(KeyEvent e) {
    if (inputSystem != null) {
      inputSystem.onKeyTyped(e);
    }
  }

  /**
   * Called when a key is pressed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyPressed(KeyEvent e) {
    if (inputSystem != null) {
      inputSystem.onKeyPressed(e);
    }
  }

  /**
   * Called when a key is released.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyReleased(KeyEvent e) {
    if (inputSystem != null) {
      inputSystem.onKeyReleased(e);
    }
  }

  /**
   * Called when the mouse is clicked.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseClicked(MouseEvent e) {
    if (inputSystem != null) {
      inputSystem.onMouseClicked(e);
    }
  }

  /**
   * Called when the mouse is pressed.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMousePressed(MouseEvent e) {
    if (inputSystem != null) {
      inputSystem.onMousePressed(e);
    }
  }

  /**
   * Called when the mouse is released.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseReleased(MouseEvent e) {
    if (inputSystem != null) {
      inputSystem.onMouseReleased(e);
    }
  }

  /**
   * Called when the mouse is dragged.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseDragged(MouseEvent e) {
    if (inputSystem != null) {
      inputSystem.onMouseDragged(e);
    }
  }

  /**
   * Called when the mouse is moved.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseMoved(MouseEvent e) {
    if (inputSystem != null) {
      inputSystem.onMouseMoved(e);
    }
  }

  /**
   * Called when the mouse wheel is moved.
   * @param e		an FX {@link ScrollEvent} representing the input event.
   */
  protected void onMouseWheelMoved(ScrollEvent e) {
    if (inputSystem != null) {
      inputSystem.onMouseWheelMoved(e);
    }
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

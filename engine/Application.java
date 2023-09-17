package engine;

import engine.support.FXFrontEnd;
import engine.support.Vec2d;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * This is your main Application class that you will contain your
 * 'draws' and 'ticks'. This class is also used for controlling
 * user input.
 */
public class Application extends FXFrontEnd {

  protected List<Screen> screens;

  public Application(String title) {
    super(title);
    this.screens = new ArrayList<>();
  }
  public Application(String title, Vec2d windowSize, boolean debugMode, boolean fullscreen) {
    super(title, windowSize, debugMode, fullscreen);
    this.screens = new ArrayList<>();
  }

  public void swapScreens() {}

  /**
   * Called periodically and used to update the state of your game.
   * @param nanosSincePreviousTick	approximate number of nanoseconds since the previous call
   */
  @Override
  protected void onTick(long nanosSincePreviousTick) {
    for (Screen s : screens) {
      // send screen deltaTime in seconds
      if(s.isActive()) {
        s.onTick((double)(nanosSincePreviousTick / 1e9));
      }
    }
  }

  /**
   * Called after onTick().
   */
  @Override
  protected void onLateTick() {
    // Don't worry about this method until you need it. (It'll be covered in class.)
  }

  /**
   *  Called periodically and meant to draw graphical components.
   * @param g		a {@link GraphicsContext} object used for drawing.
   */
  @Override
  protected void onDraw(GraphicsContext g) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onDraw(g);
      }
    }
  }

  /**
   * Called when a key is typed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  @Override
  protected void onKeyTyped(KeyEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onKeyTyped(e);
      }
    }
  }

  /**
   * Called when a key is pressed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  @Override
  protected void onKeyPressed(KeyEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onKeyPressed(e);
      }
    }
  }

  /**
   * Called when a key is released.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  @Override
  protected void onKeyReleased(KeyEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onKeyReleased(e);
      }
    }
  }

  /**
   * Called when the mouse is clicked.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  @Override
  protected void onMouseClicked(MouseEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMouseClicked(e);
      }
    }
  }

  /**
   * Called when the mouse is pressed.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  @Override
  protected void onMousePressed(MouseEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMousePressed(e);
      }
    }
  }

  /**
   * Called when the mouse is released.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  @Override
  protected void onMouseReleased(MouseEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMouseReleased(e);
      }
    }
  }

  /**
   * Called when the mouse is dragged.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  @Override
  protected void onMouseDragged(MouseEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMouseDragged(e);
      }
    }
  }

  /**
   * Called when the mouse is moved.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  @Override
  protected void onMouseMoved(MouseEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMouseMoved(e);
      }
    }
  }

  /**
   * Called when the mouse wheel is moved.
   * @param e		an FX {@link ScrollEvent} representing the input event.
   */
  @Override
  protected void onMouseWheelMoved(ScrollEvent e) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onMouseWheelMoved(e);
      }
    }
  }

  /**
   * Called when the window's focus is changed.
   * @param newVal	a boolean representing the new focus state
   */
  @Override
  protected void onFocusChanged(boolean newVal) {
    for (Screen s : screens) {
      if(s.isActive()) {
        s.onFocusChanged(newVal);
      }
    }
  }

  /**
   * Called when the window is resized.
   * @param newSize	the new size of the drawing area.
   */
  @Override
  protected void onResize(Vec2d newSize) {
    for (Screen s : screens) {
//      if(s.isActive()) {
      s.onResize(newSize);
//      }
    }
  }

  /**
   * Called when the app is shutdown.
   */
  @Override
  protected void onShutdown() {
    for (Screen s : screens) {
      s.onShutdown();
    }
  }

  /**
   * Called when the app is starting up.
   */
  @Override
  protected void onStartup() {
    for (Screen s : screens) {
      s.setParent(this); // Give each screen an object reference to this Application
      s.onStartup();
    }
  }

//  With the setParent line in place in onStartup(), this function isn't needed
//  /**
//   * Sets the parent field for each of this application's Screens.
//   */
//  protected void setChildrenParent(){
//    for (Screen s : screens) {
//      s.setParent(this);
//    }
//  }

}

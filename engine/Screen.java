package engine;

import engine.support.Vec2d;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public abstract class Screen {
  protected Vec2d size;
  protected Vec2d position;
  protected List<UIElement> uiElements;
  protected boolean isActive;
  protected Application parent;

  public Screen() {
    // initialize variables
    this.uiElements = new ArrayList<>();
    this.position = new Vec2d(0, 0);
    this.size = new Vec2d(960, 540); // default value
    this.setActivity(true);
  }

  /**
   * Screen's tick function.
   * @param deltaTime seconds since the last tick
   */
  protected void onTick(double deltaTime) {
    tick(deltaTime);
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onTick(deltaTime);
      }
    }
  }

  /**
   * Performs this Screen's tick actions.
   * @param deltaTime seconds since the last tick
   */
  protected void tick(double deltaTime) {

  }

  /**
   * Called after onTick().
   */
  protected void onLateTick() {
    // Don't worry about this method until you need it. (It'll be covered in class.)
  }

  /**
   *  Called periodically and meant to draw graphical components.
   * @param g		a {@link GraphicsContext} object used for drawing.
   */
  protected void onDraw(GraphicsContext g) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        g.save();
        uie.onDraw(g);
        g.restore(); // ensure this UIE's drawing settings don't bleed over
      }
    }
  }

  /**
   * Called when a key is typed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyTyped(KeyEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onKeyTyped(e);
      }
    }
  }

  /**
   * Called when a key is pressed.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyPressed(KeyEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onKeyPressed(e);
      }
    }
  }

  /**
   * Called when a key is released.
   * @param e		an FX {@link KeyEvent} representing the input event.
   */
  protected void onKeyReleased(KeyEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onKeyReleased(e);
      }
    }
  }

  /**
   * Called when the mouse is clicked.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseClicked(MouseEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMouseClicked(e);
      }
    }
  }

  /**
   * Called when the mouse is pressed.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMousePressed(MouseEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMousePressed(e);
      }
    }
  }

  /**
   * Called when the mouse is released.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseReleased(MouseEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMouseReleased(e);
      }
    }
  }

  /**
   * Called when the mouse is dragged.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseDragged(MouseEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMouseDragged(e);
      }
    }
  }

  /**
   * Called when the mouse is moved.
   * @param e		an FX {@link MouseEvent} representing the input event.
   */
  protected void onMouseMoved(MouseEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMouseMoved(e);
      }
    }
  }

  /**
   * Called when the mouse wheel is moved.
   * @param e		an FX {@link ScrollEvent} representing the input event.
   */
  protected void onMouseWheelMoved(ScrollEvent e) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onMouseWheelMoved(e);
      }
    }
  }

  /**
   * Called when the window's focus is changed.
   * @param newVal	a boolean representing the new focus state
   */
  protected void onFocusChanged(boolean newVal) {
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        uie.onFocusChanged(newVal);
      }
    }
  }

  /**
   * Called when the window is resized.
   * @param newSize	the new size of the drawing area.
   */
  protected void onResize(Vec2d newSize) {
    resize(newSize); // resizes this Screen
    reposition(newSize); // repositions this Screen
    for (UIElement uie : uiElements) {
//      if(s.isActive()) {
      uie.onResize(this.size); // send children this Screen's size so they are contained
//      }
    }
  }

  /**
   * Called to actually resize this Screen.
   * @param newSize the new size of the drawing area.
   */
  protected void resize(Vec2d newSize) {
    this.size = newSize;
  }

  /**
   * Called to reposition this Screen after a resize.
   */
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d(0, 0);
  }

  /**
   * Called when the app is shutdown.
   */
  protected void onShutdown() {
    for (UIElement uie : uiElements) {
      uie.onShutdown();
    }
  }

  /**
   * Called when the app is starting up.
   */
  protected void onStartup() {
    for (UIElement uie : uiElements) {
      // Set uie's parent Screen AND parent Application (for data flow)
      uie.setParent(this);
      uie.setParent(this.parent);
      uie.onStartup();
    }
  }

  // Getter for isActive
  public boolean isActive() {
    return isActive;
  }

  // Setter for isActive
  public void setActivity(boolean isActive) {
    this.isActive = isActive;
  }

  public void setParent(Application parentApp) {
    this.parent = parentApp;
  }

  /**
   * Sets the parent field for each of this Screen's UIElements.
   */
  protected void setChildrenParent(){
    for (UIElement uie : this.uiElements) {
      uie.setParent(this);
    }
  }

  public Vec2d getPosition() {
    return this.position;
  }

  public Vec2d getSize() {
    return this.size;
  }



}

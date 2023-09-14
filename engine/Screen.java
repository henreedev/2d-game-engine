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
  protected Vec2d position; // for when the top-left corner is not the drawing origin
  protected List<UIElement> uiElements;
  protected boolean isActive;
  protected Application parent;

  public Screen() {
    this.uiElements = new ArrayList<>();
    this.isActive = true;
  }

  /**
   * Screen's tick function.
   * @param deltaTime seconds since the last tick
   */
  protected void onTick(double deltaTime) {

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
        uie.onDraw(g);
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
    for (UIElement uie : uiElements) {
//      if(s.isActive()) {
      uie.onResize(newSize);
//      }
    }
  }

  // Getter for isActive
  public boolean isActive() {
    return isActive;
  }

  // Setter for isActive
  public void setActive(boolean isActive) {
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



}

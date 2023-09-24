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
  protected List<GameWorld> gameWorlds;
  protected Viewport viewport;

  public Screen() {
    // initialize variables
    this.uiElements = new ArrayList<>();
    this.gameWorlds = new ArrayList<>();
    this.position = new Vec2d(0, 0);
    this.size = new Vec2d(960, 540); // default value
    this.setActivity(true);
  }

  protected void addGameWorld(GameWorld gameWorld) {
    this.gameWorlds.add(gameWorld);
    this.viewport.addGameWorld(gameWorld);
  }

  protected void onTick(double deltaTime) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onTick(deltaTime);
      }
    }
    tick(deltaTime);
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onTick(deltaTime);
      }
    }
  }

  protected void onDraw(GraphicsContext g) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onDraw(g);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        g.save();
        uie.onDraw(g, this.position);
        g.restore();
      }
    }
  }

  protected void onKeyTyped(KeyEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onKeyTyped(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onKeyTyped(e);
      }
    }
  }

  protected void onKeyPressed(KeyEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onKeyPressed(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onKeyPressed(e);
      }
    }
  }

  protected void onKeyReleased(KeyEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onKeyReleased(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onKeyReleased(e);
      }
    }
  }

  protected void onMouseClicked(MouseEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMouseClicked(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onMouseClicked(e);
      }
    }
  }

  protected void onMousePressed(MouseEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMousePressed(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onMousePressed(e);
      }
    }
  }

  protected void onMouseReleased(MouseEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMouseReleased(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onMouseReleased(e);
      }
    }
  }

  protected void onMouseDragged(MouseEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMouseDragged(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onMouseDragged(e);
      }
    }
  }

  protected void onMouseMoved(MouseEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMouseMoved(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
        uie.onMouseMoved(e);
      }
    }
  }

  protected void onMouseWheelMoved(ScrollEvent e) {
    if (!this.gameWorlds.isEmpty()) {
      for (GameWorld gw : this.gameWorlds) {
        gw.onMouseWheelMoved(e);
      }
    }
    for (UIElement uie : uiElements) {
      if (uie.isActive()) {
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
      uie.onResize(this.size); // send children this Screen's size so they are contained
    }
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

  protected void onDraw(GraphicsContext g, Vec2d parentPosition) {
    draw(g, parentPosition);
    for (UIElement uie : uiElements) {
      if(uie.isActive()){
        g.save();
        uie.onDraw(g, this.position.plus(parentPosition));
        g.restore(); // ensure this UIE's drawing settings don't bleed over
      }
    }
  }

  /**
   * Actually draws this screen.
   * @param g the GraphicsContext to draw with
   * @param parentPosition the absolute position to draw relative to
   */
  protected void draw(GraphicsContext g, Vec2d parentPosition) {

  }


}

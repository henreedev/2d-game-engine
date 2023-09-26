package alc.assets;

import engine.GameObject;
import engine.SpaceConverter;
import engine.components.GraphicsComponent;
import engine.components.InputComponent;
import engine.components.TransformComponent;
import engine.components.behaviors.DrawBehavior;
import engine.components.behaviors.DrawLayer;
import engine.components.behaviors.InputBehavior;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;

public class AlcUnit extends GameObject {
  private DrawBehavior drawBehavior;
  private InputBehavior inputBehavior;
  private boolean isDragged;
  private boolean isClone;

  public AlcUnit() {
    super();
    // TRANSFORM INITIALIZATION
    this.getTransform().setPosition(new Vec2d(76, 41));
    this.getTransform().setSize(new Vec2d(8, 8));
    // DRAW BEHAVIOR INITIALIZATION
    this.drawBehavior = new DrawBehavior(this) {
      @Override
      public void onDraw(GraphicsContext g) {
        TransformComponent tc = getParentTransform();
        Vec2d pos = tc.getPosition();
        Vec2d size = tc.getSize();
//        g.setLineWidth(1);
        g.setStroke(Color.rgb(75, 50, 255));
        g.strokeRect(pos.x, pos.y, size.x, size.y);
      }
    };
    // INPUT BEHAVIOR INITIALIZATION
    this.inputBehavior = new InputBehavior(this) {
      // UNUSED METHODS vvv
      @Override
      public void onKeyTyped(KeyEvent e) {

      }
      @Override
      public void onKeyPressed(KeyEvent e) {

      }
      @Override
      public void onKeyReleased(KeyEvent e) {

      }
      @Override
      public void onMouseMoved(MouseEvent e) {

      }
      @Override
      public void onMouseWheelMoved(ScrollEvent e) {

      }
      @Override
      public void onMouseClicked(MouseEvent e) {

      }
      // UNUSED METHODS ^^^

      private void spawnClone() {
        parent.addGameObject(new AlcUnit());
      }
      @Override
      public void onMousePressed(MouseEvent e) {
        if (isWithinTransform(e)) {
          if (!isClone) {
            spawnClone();
          }
          isDragged = true;
          isClone = true;
          // TODO store offset from top left (so that dragging occurs from the initially clicked point)
        }
        System.out.println("Pressing" +isDragged);
      }

      @Override
      public void onMouseReleased(MouseEvent e) {
        System.out.println("Releasing" +isDragged);
        isDragged = false;
      }

      @Override
      public void onMouseDragged(MouseEvent e) {
        if (isDragged) {
          // TODO use offset form top left
          SpaceConverter sc = parent.converter;
          Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
          getTransform().setPosition(clickPoint);
        }
      }
    };

    this.addComponent(new GraphicsComponent(this, drawBehavior, DrawLayer.BOTTOM));
    this.addComponent(new InputComponent(this, inputBehavior));
  }

}

package alc.assets;

import engine.GameObject;
import engine.SpaceConverter;
import engine.components.GraphicsComponent;
import engine.components.InputComponent;
import engine.components.TransformComponent;
import engine.components.behaviors.DrawLayer;
import engine.support.Vec2d;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;

public class AlcUnit extends GameObject {
  private boolean isDragged;
  private boolean isClone;
  protected Color color = Color.rgb(75, 50, 255);

  public AlcUnit() {
    super();
    // TRANSFORM INITIALIZATION
    this.getTransform().setPosition(new Vec2d(76, 41));
    this.getTransform().setSize(new Vec2d(8, 8));
    // ADD COMPONENTS
    this.addComponent(new GraphicsComponent(this,  DrawLayer.BOTTOM) {
      @Override
        public void onDraw(GraphicsContext g) {
          TransformComponent tc = getTransform();
          Vec2d pos = tc.getPosition();
          Vec2d size = tc.getSize();
//        g.setLineWidth(1);
//        g.setStroke(color);
//        g.strokeRect(pos.x, pos.y, size.x, size.y);
          // TODO generalize sprite index to allow extension
          Vec2d pickaxeSpriteIndex = new Vec2d(0, 0);
          if (parentWorld.spriteSheet != null) {
            parentWorld.spriteSheet.drawSprite(g, pickaxeSpriteIndex, pos, size);
          }
        }})
        .addComponent(new InputComponent(this) {
          @Override
          public void onMouseClicked(MouseEvent e) {
            if (isWithinTransform(e)) {
              Random rand = new Random();
              color = Color.rgb(
                  rand.nextInt(256),
                  rand.nextInt(256),
                  rand.nextInt(256)
              );
            }
          }

          private void spawnClone() {
            parentWorld.addGameObject(new AlcUnit());
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
          }

          @Override
          public void onMouseReleased(MouseEvent e) {
            isDragged = false;
          }

          @Override
          public void onMouseDragged(MouseEvent e) {
            if (isDragged) {
              // TODO use offset from top left
              SpaceConverter sc = parentWorld.converter;
              Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
              getTransform().setPosition(clickPoint);
            }
          }
        });
  }

}

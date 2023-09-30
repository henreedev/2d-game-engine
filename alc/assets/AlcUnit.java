package alc.assets;

import engine.GameObject;
import engine.SpaceConverter;
import engine.components.CollisionComponent;
import engine.components.ComponentTag;
import engine.components.GraphicsComponent;
import engine.components.InputComponent;
import engine.components.TransformComponent;
import engine.components.DrawLayer;
import engine.components.shapes.Circle;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class AlcUnit extends GameObject<AlcType> {
  public static boolean unitGrabbed = false;
  private boolean isDragged;
  private boolean isClone;
  protected Color color = Color.rgb(38, 23, 30);
  private Vec2d grabOffset = new Vec2d(0, 0);

  public AlcUnit(AlcType type, Vec2d pos, Vec2d size) {
    super();
    // TYPE INITIALIZATION
    this.setObjectType(type);
    // check if this is a result of combination? treat like clone
    isClone = (type == AlcType.BLUE_POTION   ||
               type == AlcType.PURPLE_POTION ||
               type == AlcType.YELLOW_POTION ||
               type == AlcType.TRASH);
    // TRANSFORM INITIALIZATION
    this.getTransform().setPosition(pos);
    this.getTransform().setSize(size);
    // ADD COMPONENTS
    // GRAPHICS COMPONENT
    this.addComponent(new GraphicsComponent(this,  DrawLayer.BOTTOM) {
      @Override
        public void onDraw(GraphicsContext g) {
          TransformComponent tc = getTransform();
          Vec2d pos = tc.getPosition();
          Vec2d size = tc.getSize();
          Vec2d spriteIndex = new Vec2d(0, getObjectType().ordinal());
          int maxIndex = 7; // 7 sprites in the sheet, arranged vertically
          if (parentWorld.spriteSheet != null) {
            if(spriteIndex.y < maxIndex) {
              parentWorld.spriteSheet.drawSprite(g, spriteIndex, pos, size);
            } else {
              g.setFill(color);
              g.fillRect(pos.x, pos.y, size.x, size.y);
            }
          }
        }})

        // INPUT COMPONENT
        .addComponent(new InputComponent(this) {
          @Override
          public void onMouseClicked(MouseEvent e) {
//            if (isWithinTransform(e)) {
//              Random rand = new Random();
//              color = Color.rgb(
//                  rand.nextInt(256),
//                  rand.nextInt(256),
//                  rand.nextInt(256)
//              );
//            }
          }

          private void spawnClone() {
            parentWorld.addGameObject(new AlcUnit(getObjectType(), getTransform().getPosition(),
                getTransform().getSize()));
          }

          private void storeOffset(MouseEvent e) {
            SpaceConverter sc = parentWorld.converter;
            Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
            grabOffset = getTransform().getPosition().minus(clickPoint);
          }

          @Override
          public void onMousePressed(MouseEvent e) {
            if (!unitGrabbed && type != AlcType.TRASH) { // only one unit can be grabbed at a time
              if (isWithinTransform(e)) {
                unitGrabbed = true;
                storeOffset(e);
                if (!isClone) {
                  spawnClone();
                }
                isDragged = true;
                isClone = true;
                // TODO store offset from top left (so that dragging occurs from the initially clicked point)
              }
            }
          }

          @Override
          public void onMouseReleased(MouseEvent e) {
            isDragged = false;
            unitGrabbed = false;
          }

          @Override
          public void onMouseDragged(MouseEvent e) {
            if (isDragged) {
              // TODO use offset from top left
              SpaceConverter sc = parentWorld.converter;
              Vec2d clickPoint = sc.screenToGameSpace(new Vec2d(e.getX(), e.getY()));
              TransformComponent tc = getTransform();
              tc.setPosition(clickPoint.plus(grabOffset));
              CollisionComponent cc = (CollisionComponent) getComponent(ComponentTag.COLLISION);
              Circle hitbox = (Circle) cc.getShape();
              hitbox.setRadius(tc.getSize().x / 2);
              hitbox.setCenter(tc.getPosition().plus(tc.getSize().sdiv(2.0f)));
            }
          }
        })
        .addComponent(new CollisionComponent(this, new Circle(size.x / 2, pos.plus(size.sdiv(2)))) {
          @Override
          public void onCollision(GameObject<?> other) {
            AlcType thisType = getObjectType();
            AlcType otherType = (AlcType) other.getObjectType();
            // OBJECT INTERACTION BEHAVIOR
            // purple plants combine to make purple potion
            // blue plants combine to make blue potion
            // purple potion + blue potion = yellow potion (final unit)
            // note: no need to check other "direction" in conditional b/c onCollision is called for both objects
            if (!unitGrabbed && bothClones(other)) {
              // COMBINE MUSHROOMS
              if (thisType == AlcType.LIGHT_BLUE_MUSHROOM && otherType == AlcType.DARK_BLUE_MUSHROOM) {
                // delete this and other, make blue potion
                deleteThisAndOther(other);
                parentWorld.addGameObject(new AlcUnit(AlcType.BLUE_POTION,
                    getTransform().getPosition(),
                    getTransform().getSize()));
              }
              // COMBINE PLANTS
              if (thisType == AlcType.PURPLE_FLOWER && otherType == AlcType.PURPLE_PLANT) {
                // delete this and other, make purple potion
                deleteThisAndOther(other);
                parentWorld.addGameObject(new AlcUnit(AlcType.PURPLE_POTION,
                    getTransform().getPosition(),
                    getTransform().getSize()));
              }
              // COMBINE POTIONS
              if (thisType == AlcType.BLUE_POTION && otherType == AlcType.PURPLE_POTION) {
                // delete this and other, make yellow potion
                deleteThisAndOther(other);
                parentWorld.addGameObject(new AlcUnit(AlcType.YELLOW_POTION,
                    getTransform().getPosition(),
                    getTransform().getSize()));
              }
              // DELETE ON CONTACT WITH TRASH
              if (thisType == AlcType.TRASH && otherType != AlcType.TRASH) {
                // delete other
                parentWorld.removeGameObject(other);
              }
            }
          }

          private void deleteThisAndOther(GameObject<?> other) {
            parentWorld.removeGameObject(parent);
            parentWorld.removeGameObject(other);
          }

          private boolean bothClones(GameObject<?> other) {
            AlcUnit otherAlcUnit = (AlcUnit) other;
            return isClone && otherAlcUnit.isClone;
          }
        });
  }

}

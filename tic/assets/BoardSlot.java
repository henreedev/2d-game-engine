package tic.assets;

import engine.support.Vec2d;
import engine.uitoolkit.Button;
import engine.uitoolkit.Rectangle;
import javafx.scene.paint.Color;

public class BoardSlot extends Button {

  protected int slotIndex;
  // percent of the board length allocated to board slots
  protected static double slotPercent = 0.85; // allows for 2 5% slices
  // along the top of the board we'll have:
  // 30% slot 5% line/divider 30% slot 5% line/divider 30% slot
  protected static double extraSpacePercent = 0.075;

  public BoardSlot (int slotIndex) {
    super(new BoardSlotBehavior(slotIndex));
    this.slotIndex = slotIndex; // maybe not necessary
    this.uiElements.add(new Rectangle(Color.DARKBLUE, true, 15));
  }

  @Override
  protected void resize(Vec2d newSize) {
    double slotLength = newSize.x * slotPercent / 3; // 1/3 of slot space = 1 slot
    this.size = new Vec2d(slotLength, slotLength);
  }

  @Override
  protected void reposition(Vec2d newSize) {
    double slotLength = newSize.x * slotPercent / 3; // 1/3 of slot space = 1 slot
    double dividerLength = newSize.x *
        (1 - slotPercent - extraSpacePercent) / 2; // 1/2 of divider space = 1 divider
    double extraSpaceLength = newSize.x * extraSpacePercent;
    double x = (slotIndex % 3) * (slotLength + dividerLength) + extraSpaceLength / 2;
    double y = (slotIndex / 3) * (slotLength + dividerLength) + extraSpaceLength / 2;

    this.position = new Vec2d(x, y).plus(this.parentScreen.getPosition());
  }
}

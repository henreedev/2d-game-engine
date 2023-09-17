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

  private final X x;
  private final O o;

  public BoardSlot (int slotIndex) {
    super(new BoardSlotBehavior(slotIndex));
    this.slotIndex = slotIndex; // maybe not necessary
    this.uiElements.add(new Rectangle(Color.rgb(30, 30, 30), true, 15));
    this.x = new X(Color.rgb(100, 100, 255));
    this.o = new O(Color.rgb(255, 170, 100));
    this.uiElements.add(this.x);
    this.uiElements.add(this.o);

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

    this.position = new Vec2d(x, y);
  }

  public void showLetter(boolean isX, boolean isGhost) {
    if (isX && isGhost) {
      this.x.setActivity(true);
      this.x.setGhost(true);
      this.o.setActivity(false);
    } else if (isX) { // not ghost
      this.x.setActivity(true);
      this.x.setGhost(false);
      this.o.setActivity(false);
    } else if (isGhost) {
      this.o.setActivity(true);
      this.o.setGhost(true);
      this.x.setActivity(false);
    } else {
      this.o.setActivity(true);
      this.o.setGhost(false);
      this.x.setActivity(false);
    }

  }
  public void clearLetter() {
    this.x.setActivity(false);
    this.o.setActivity(false);
  }
}

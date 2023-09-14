package tic.assets;

import engine.UIElement;
import engine.support.Vec2d;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board extends UIElement {

  // Board drawing variables (update as needed in resize
  private double height;  // Height of the board
  private double x;        // X-coordinate of the board

  public Board() {
    super();
    this.colors = new ArrayList<>();
    this.colors.add(Color.BLACK);
    this.isActive = true;
  }

  @Override
  public void onDraw(GraphicsContext g){
    g.setFill(colors.get(0));  // Set the fill color
    // Y-coordinate of the board
    double y = 0;
    g.fillRect(x, y, height, height);           // Draw the filled rectangle
  }

  @Override
  protected void onResize(Vec2d newSize) {
    // Center board in screen, taking as much vertical area as possible:
    this.height = newSize.y;
    this.x = (newSize.x - newSize.y) / 2; // only works if aspect ratio > 1!
  }


}

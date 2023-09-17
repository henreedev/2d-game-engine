package engine.uitoolkit;

import engine.UIElement;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Text extends UIElement {

  protected String text;
  protected Font font;
  protected boolean isFilled;
  protected double strokeWidth;
  protected double wrapDistance;
  protected String fontString;
  protected double fontSize;
  protected TextAlignment textAlignment = TextAlignment.LEFT;

  public Text(String text) {
    super();
    this.text = text;
    this.font = Font.font("ARIAL");
    this.fontString = font.getName();
  }

  public Text(String text, Font font, Color color, TextAlignment textAlignment) {
    super(color);
    this.text = text;
    this.font = font;
    this.isFilled = true;
    this.strokeWidth = 0;
    this.textAlignment = textAlignment;
    this.fontString = font.getName();
  }

  public Text(String text, Font font, Color color, boolean isFilled, double strokeWidth) {
    super(color);
    this.text = text;
    this.font = font;
    this.isFilled = isFilled;
    this.strokeWidth = strokeWidth;
    this.fontString = font.getName();
  }

  public Text(String text, Font font, Color color, boolean isFilled, double strokeWidth, double wrapDistance) {
    super(color);
    this.text = text;
    this.font = font;
    this.isFilled = isFilled;
    this.strokeWidth = strokeWidth;
    this.wrapDistance = wrapDistance;
    this.fontString = font.getName();
  }

  public void setText(String newText) {
    this.text = newText;
  }

  @Override
  protected void draw(GraphicsContext g, Vec2d parentPosition) {
    Vec2d pos = this.position.plus(parentPosition);
    g.setFont(Font.font(fontString, fontSize));
    g.setTextAlign(textAlignment);
    if(isFilled) {
      g.setFill(color);
      g.fillText(text, pos.x, pos.y);
    } else {
      g.setStroke(color);
      g.setLineWidth(strokeWidth);
      g.strokeText(text, pos.x, pos.y);
    }
  }

  @Override
  protected void resize(Vec2d newSize) {

  }

  @Override
  protected void reposition(Vec2d newSize) {
    this.position = new Vec2d(newSize.x / 2, newSize.y / 2);
  }


}

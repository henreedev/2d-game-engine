package alc.assets;

import alc.AlcWorld;
import engine.GameObject;
import engine.components.CollisionComponent;
import engine.components.GraphicsComponent;
import engine.components.TransformComponent;
import engine.components.DrawLayer;
import engine.components.shapes.AAB;
import engine.support.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AlcBackground extends GameObject<AlcType> {
  public AlcBackground() {
    super();
    this.setObjectType(AlcType.BACKGROUND);
    // TRANSFORM INITIALIZATION
    this.getTransform().setPosition(new Vec2d(0, 0));
    this.getTransform().setSize(new Vec2d(AlcWorld.alcGameDimensions));
    // DRAW BEHAVIOR INITIALIZATION
    this.addComponent(new GraphicsComponent(this, DrawLayer.BACKGROUND) {
      @Override
      public void onDraw(GraphicsContext g) {
        TransformComponent tc = getTransform();
        Vec2d pos = tc.getPosition();
        Vec2d size = tc.getSize();
        g.setFill(Color.rgb(150, 150, 150));
        g.fillRect(pos.x, pos.y, size.x, size.y);
        g.setLineWidth(2);
        g.strokeRect(pos.x, pos.y, size.x, size.y);
      }
    });
  }
}

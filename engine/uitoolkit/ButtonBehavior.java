package engine.uitoolkit;

import javafx.scene.input.MouseEvent;

public interface ButtonBehavior {

  void doOnClick(MouseEvent e);
  void doOnHover(MouseEvent e);

}

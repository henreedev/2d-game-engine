package tic.assets;

import engine.uitoolkit.ButtonBehavior;
import javafx.scene.input.MouseEvent;
import tic.App;
import tic.TicScreen;

public class StartButtonBehavior implements ButtonBehavior {

  @Override
  public void doOnClick(MouseEvent e) {
    MenuScreen.shouldStartGame = true;
  }

  @Override
  public void doOnHover(MouseEvent e) {

  }
}

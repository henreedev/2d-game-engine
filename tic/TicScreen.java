package tic;

import engine.Screen;
import java.util.ArrayList;
import tic.assets.Board;

public class TicScreen extends Screen {
  public TicScreen(){
    super();
    this.uiElements = new ArrayList<>();
    // Add UIElements to this Screen here:
    uiElements.add(new Board());
    // Link UIElements to this screen
    setChildrenParent();
  }
}

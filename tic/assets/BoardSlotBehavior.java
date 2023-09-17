package tic.assets;

import static tic.TicScreen.whoWon;

import engine.uitoolkit.ButtonBehavior;
import javafx.scene.input.MouseEvent;
import tic.TicScreen;

public class BoardSlotBehavior implements ButtonBehavior {

  private final int slotIndex;

  public BoardSlotBehavior(int slotIndex) {
    this.slotIndex = slotIndex;
  }

  @Override
  public void doOnClick(MouseEvent e) {
    if(whoWon.equals("")) {
      String turn = TicScreen.whoseTurn;
      String[] board = TicScreen.board;
      // if unfilled / only ghost, place X or O
      if (!board[slotIndex].equals("X") || board[slotIndex].equals("O")) {
        board[slotIndex] = turn;
      }
      if(!TicScreen.checkForWin()) {
        TicScreen.swapTurn();
      }
    }

  }

  @Override
  public void doOnHover(MouseEvent e) {
    String turn = TicScreen.whoseTurn;
    String[] board = TicScreen.board;
    if (board[slotIndex].equals("")) {
      // clear ghosts
      for (int i = 0; i < board.length; i++) {
        if (board[i].equals("x") || board[i].equals("o")) {
          board[i] = "";
        }
      }
      // add ghost
      board[slotIndex] = turn.toLowerCase();
    }
  }
}

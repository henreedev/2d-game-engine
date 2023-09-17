package tic;

import engine.Screen;
import java.util.Arrays;
import tic.assets.Background;
import tic.assets.Board;
import tic.assets.Timer;

public class TicScreen extends Screen {

  // Game state variables
  public static String statusMessage = "";
  public static String whoseTurn = "X"; // either "X" or "O"
  public static String whoWon = ""; // "", "X", or "O"
  public static String[] board = new String[9];
  public static boolean shouldStartGame = false;
  static {
    Arrays.fill(board, "");
  }
  // Winning board indices for Tic-Tac-Toe
  public static int[][] triples = {
      {0, 1, 2}, // row 1
      {3, 4, 5}, // row 2
      {6, 7, 8}, // row 3
      {0, 3, 6}, // col 1
      {1, 4, 7}, // col 2
      {2, 5, 8}, // col 3
      {0, 4, 8}, // top left to bottom right diag
      {2, 4, 6}  // top right to bottom left diag
  };

  public TicScreen(){
    super();
    // Add UIElements to this Screen here:
    uiElements.add(new Background());
    uiElements.add(new Board());
  }

  public static void swapTurn() {
    if (whoseTurn.equals("X")) {
      whoseTurn = "O";
    } else {
      whoseTurn = "X";
    }
    Timer.resetTimeVal();
  }

  public static boolean checkForWin() {
    for(int[] triple : triples) {
      int index0 = triple[0];
      int index1 = triple[1];
      int index2 = triple[2];

      if (board[index0].equals("X")
          && board[index1].equals("X")
          && board[index2].equals("X")) {
        System.out.println("X Winning triple: "+index0 +"," + index1 + ',' + index2);
        // X got 3 in a row
        whoWon = "X";
        winSequence();
        return true;
      } else if (board[index0].equals("O")
          && board[index1].equals("O")
          && board[index2].equals("O")) {
        System.out.println("O Winning triple: "+index0 +"," + index1 + ',' + index2);
        // O got 3 in a row
        whoWon = "O";
        winSequence();
        return true;
      }
    }
    return false;
  }

  public static boolean checkForDraw() {
    boolean spaceAvailable = false;
    for (String s : board) {
      if (s.equals("")) {
        spaceAvailable = true;
        break;
      }
    }
    if (!spaceAvailable && whoWon.equals("")) {
      whoWon = "Nobody";
      System.out.println("It's a draw!");
      return true;
    }
    return false;
  }

  public static void winSequence() {
    switch (whoWon) {
      case "X" -> statusMessage = "X won the game!";
      case "O" -> statusMessage = "O won the game!";
      case "Nobody" -> statusMessage = "It's a draw!";
      default -> statusMessage = "ERROR";
    }
  }

   public static void resetGameData() {
    whoseTurn = "X";
    whoWon = "";
    Arrays.fill(board, "");
    Timer.resetTimeVal();
  }
}

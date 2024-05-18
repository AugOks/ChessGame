package Model.logic;


import java.util.Scanner;

public class ChessGame {
  private ChessBoard board;
  /**
   * The canvas is a 2D array of characters that represents the board.
   */
  private char canvas[][] = new char[8][8];

  /**
   * Constructor for the ChessGame class
   */
    public ChessGame() {;
    }

  /**
   * This method starts the game and allows the player to play the game.
   */
    public void playGame() {
      char command = ' ';
        System.out.println("Playing chess press P to play a piece, Q to quit");

        while (command != 'q') {
          drawBoard();

          System.out.println("Enter the command: ");
          Scanner scanner = new Scanner(System.in);
            command = scanner.next().charAt(0);

            switch (command) {
              case 'p':
                System.out.println("Enter the x and y coordinates of the piece you want to move");
                System.out.print("x: ");
                int x = scanner.nextInt();
                System.out.print("y: ");
                int y = scanner.nextInt();
                System.out.println("Enter the x and y coordinates of the new position");
                System.out.print("x: ");
                int newX = scanner.nextInt();
                System.out.print("y: ");
                int newY = scanner.nextInt();
                if (board.movePiece(x, y, newX, newY)) {
                  System.out.println("Piece moved");
                } else {
                  System.out.println("Invalid move");
                }
                break;
              default:
                break;

            }
        }
    }

  /**
   * This method draws the board on the console.
   */
  private void drawBoard(){
      String color;
      for (int i = 0; i < canvas.length; i++) {
        System.out.println();
        for (int j = 0; j < canvas[i].length; j++) {
          if (board.getPiece(i, j) != null) {
            canvas[i][j] = board.getPiece(i, j).getSymbol();
            color = board.getPiece(i, j).getColor();
          } else {
            canvas[i][j] = 'X';
            color = "\u001B[37m";
          }
          System.out.print( color  +  canvas[i][j] + "\u001B[0m");
        }
      }
      System.out.println();
    }
}

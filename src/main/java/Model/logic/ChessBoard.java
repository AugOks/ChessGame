package Model.logic;


import Model.entity.Bishop;
import Model.entity.King;
import Model.entity.Knight;
import Model.entity.Pawn;
import Model.entity.Piece;
import Model.entity.Queen;
import Model.entity.Rook;
import java.util.ArrayList;

/**
 * The class ChessBoard represents the chess board.

 */
public class ChessBoard {
  /**
   * The board is represented as a 2D array of pieces.
   */
  private BoardObserver observer;
  private final Piece[][] board = new Piece[8][8];

  /**
   * The removedPieces list contains all the pieces that have been removed from the board.
   */
  private ArrayList<Piece> removedPieces = new ArrayList<>();

  /**
   * The constructor initializes the board with the pieces in their starting positions.
   */
  public ChessBoard(BoardObserver observer) {
    this.observer = observer;
    for (int i = 0; i < board.length; i++) {
      board[1][i] = new Pawn(true);
      board[6][i] = new Pawn(false);

      for (int j = 2; j < 6; j++) {
        board[j][i] = null;
      }
      createRowOfPieces(true);
      createRowOfPieces(false);
    }
  }

  private  void updateObserver() {
    observer.update();
  }

  /**
   * This method sets all non pawn pieces in their starting positions.
   * @param white if true, the pieces are white, otherwise they are black.
   */
  private void createRowOfPieces(boolean white){
    int row = white ? 0 : 7;
    board[row][0] = new Rook(white);
    board[row][1] = new Knight(white);
    board[row][2] = new Bishop(white);
    board[row][3] = new Queen(white);
    board[row][4] = new King(white);
    board[row][5] = new Bishop(white);
    board[row][6] = new Knight(white);
    board[row][7] = new Rook(white);
  }

  /**
   * returns the piece at the given position.
   * @param x the x coordinate of the piece.
   * @param y the y coordinate of the piece.
   * @return the piece at the given position.
   */
  public Piece getPiece(int x, int y) {
    return board[x][y];
  }

  /**
   * This method moves a piece from one position to another.
   * @param x the x coordinate of the piece to move.
   * @param y the y coordinate of the piece to move.
   * @param newX the x coordinate of the new position.
   * @param newY the y coordinate of the new position.
   * @return true if the piece was moved, false otherwise.
   */
  public boolean movePiece(int x, int y, int newX, int newY) {
    boolean pieceMoved = false;
    Piece piece = board[x][y];
    if (canMove(piece, x, y, newX, newY)) {
      board[x][y] = null;
      if (board[newX][newY] != null) {
        removedPieces.add(board[newX][newY]);
      }
      board[newX][newY] = piece;
        pieceMoved = true;
    }
    if ( pieceMoved == false) {
      System.out.println("Invalid move");
    }
    if (pieceMoved) {
      if (board[newX][newY] instanceof King) {
        System.out.println("Game Over");
      }
    }
    if (pieceMoved && board[newX][newY] != null) {
      removedPieces.add(board[newX][newY]);
    }
    updateObserver();
    return pieceMoved;
  }

  /**
   * This method checks if a piece can move from one position to another.
   * @param piece the piece to move.
   * @param x the x coordinate of the piece to move.
   * @param y the y coordinate of the piece to move.
   * @param newX the x coordinate of the new position.
   * @param newY the y coordinate of the new position.
   * @return
   */
  private boolean canMove(Piece piece, int x, int y, int newX, int newY) {
    boolean canMove = false;
    float xDirection = Math.signum(newX - x);
    float yDirection = Math.signum(newY - y);
    int delta_x =Math.abs( newX - x);
    int delta_y =Math.abs( newY - y);
    if(piece == null) {
    return false;
    }
    if (board[newX][newY] != null && board[newX][newY].isWhite() == piece.isWhite()) {
      return false;
    }
    if (piece.allowedMove(delta_x, delta_y)) {
      if (piece instanceof Knight) {
        canMove = true;
      } else {
        for (int i = 1; i <= delta_x ; i++){
          int step = (int) (x+i*xDirection);
          if (board[step][y] == null || board[step][y].isWhite() != piece.isWhite()) {
            canMove = true;
          } else {
            canMove = false;
          }
        }
        for (int i = 1; i <= delta_y ; i++){
          int step = (int) (y+i*yDirection);
          if (board[x][step] == null || board[x][step].isWhite() != piece.isWhite()) {
            canMove = true;
          } else {
            canMove = false;
          }
        }
      }

    }
    return  canMove;
  }

}
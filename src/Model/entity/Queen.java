package Model.entity;

/**
 * Represents a queen piece in the chess game.
 */
public class Queen extends Piece {


  public Queen(boolean white) {
    super(white);
  }

  @Override
  public boolean allowedMove(int x, int y) {
    boolean move = false;
    if (x == y || x == 0 && y < 8 || x < 8 && y == 0) {
      move = true;
    }
    return move;
  }

  @Override
  public char getSymbol() {
    return 'Q';
  }


}

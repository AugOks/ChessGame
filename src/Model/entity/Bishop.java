package Model.entity;

/**
 * Represents a bishop piece in the chess game.
 */
public class Bishop extends Piece {

  public Bishop(boolean white) {
    super(white);
  }

  @Override
  public boolean allowedMove(int x, int y) {
    return x == y;
  }

  @Override
  public char getSymbol() {
    return 'B';
  }

}

package Model.entity;

/**
 * Represents the King piece
 */
public class King extends Piece {
  public King(boolean white) {
    super(white);
  }

  @Override
  public boolean allowedMove(int x, int y) {
    if (x > 1 || y > 1) {
      return false;
    }
    return true;
  }

  @Override
  public char getSymbol() {
    return 'K';
  }


}

package Model.entity;

/**
 *  Represents a rook piece in the chess game.
 */
public class Rook extends Piece {

  private final String image;
  public Rook(boolean white) {
    super(white);
    if (white) {
      image = "whtRook";
    } else {
      image = "blkRook";
    }
  }

  @Override
  public String imageLink() {
    return image;
  }

  /**
   * Checks if the move is allowed for the rook piece.
   * @param x the x coordinate of the new position.
   * @param y the y coordinate of the new position.
   * @return true if the move is allowed, false otherwise.
   */
  @Override
  public boolean allowedMove(int x, int y) {
    if (x == 0 && y < 8 || x < 8 && y == 0) {
      return true;
    }
    return false;
  }

  @Override
  public char getSymbol() {
    return 'R';
  }


}

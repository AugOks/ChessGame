package Model.entity;

/**
 * Knight class that extends Piece class.
 */
public class Knight extends Piece {
  public Knight(boolean white) {
    super(white);
  }

  @Override
  public boolean allowedMove(int x, int y) {
    boolean move = false;
    if (x == 2 && y == 1) {
     move = true;
    }
    if (x == 1 && y == 2) {
      move = true;
    }
    return move;
  }

  @Override
  public char getSymbol() {
    return 'H';
  }


}

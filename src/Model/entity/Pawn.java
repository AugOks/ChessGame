package Model.entity;

/**
 * This class represents the Pawn piece
 */
public class Pawn extends Piece { // This class is a subclass of Piece

  private boolean firstMove;

  public  Pawn(boolean white) {
    super(white);
    firstMove = true;
  }

  @Override
  public boolean allowedMove(int x, int y) {
    boolean move = false;
    if (firstMove){
      if (x == 0 && y < 3 || x < 3 && y == 0) {
        move = true;
      }
    } else {
      if (x == 0 && y < 2 || x < 2 && y == 0) {
        move = true;
      }
    }
    return  move;
  }

  @Override
  public char getSymbol() {
    return 'P';
  }
}

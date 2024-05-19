package Model.entity;

/**
 * This class represents the Pawn piece
 */
public class Pawn extends Piece { // This class is a subclass of Piece
private  final String image;
  private boolean firstMove;

  public  Pawn(boolean white) {
    super(white);
    firstMove = true;
    if (white){
      image = "whtPawn";
    }else{
      image = "blkPawn";
    }
  }

  @Override
  public String imageLink() {
    return image;
  }

  @Override
  public boolean allowedMove(int x, int y) {
    boolean move = false;
    if (firstMove){
      if (y == 0 && x < 3 ) {
        move = true;
      }
    } else {
      if (y == 0 && x < 2 ) {
        move = true;
      }
    }
    firstMove = false;
    return  move;
  }

  @Override
  public char getSymbol() {
    return 'P';
  }
}

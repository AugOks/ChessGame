package Model.entity;

/**
 * Represents a bishop piece in the chess game.
 */
public class Bishop extends Piece {

private final String image;
  public Bishop(boolean white) {
    super(white);
    if (white){
      image = "whtBishop";
    }else{
      image = "blkBishop";
    }
  }

  @Override
  public String imageLink() {
    return image;
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

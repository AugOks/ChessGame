package Model.entity;

/**
 * Represents the King piece
 */
public class King extends Piece {
  private final String image;
  public King(boolean white) {
    super(white);
    if (white){
      image = "whtKing";
    }else{
      image = "blkKing";
    }
  }

  @Override
  public String imageLink() {
    return image;
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

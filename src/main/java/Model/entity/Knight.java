package Model.entity;

/**
 * Knight class that extends Piece class.
 */
public class Knight extends Piece {
  private final String image;
  public Knight(boolean white) {
    super(white);
    if (white){
      image = "whtKnight";
    }else{
      image = "blkKnight";
    }
  }

  @Override
  public String imageLink() {
    return image;
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

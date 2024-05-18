package Model.entity;

public abstract class Piece {

  private boolean white;
  private String color;

  public Piece(boolean white) {
    this.white = white;
    if (white) {
      color = "\u001B[34m";
    } else {
      color = "\u001B[31m";
    }
  }

  public abstract boolean allowedMove( int x, int y);
  public boolean isWhite() {
    return white;
  }
  public String getColor() {
    return color;
  }
  public abstract char getSymbol();
}

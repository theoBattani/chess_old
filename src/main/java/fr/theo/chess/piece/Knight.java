
package fr.theo.chess.piece;

public class Knight extends Piece{

  public Knight(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();
    addIfValid(x+1, y+2);
    addIfValid(x+1, y-2);
    addIfValid(x-1, y+2);
    addIfValid(x-1, y-2);
    addIfValid(x+2, y+1);
    addIfValid(x+2, y-1);
    addIfValid(x-2, y+1);
    addIfValid(x-2, y-1);
  }
}










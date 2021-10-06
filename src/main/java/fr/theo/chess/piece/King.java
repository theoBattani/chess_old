
package fr.theo.chess.piece;

public class King extends Piece {

  public King(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();
    addIfValid(x+1, y+1);
    addIfValid(x+1, y-1);
    addIfValid(x-1, y+1);
    addIfValid(x-1, y-1);
    addIfValid(x+1, y);
    addIfValid(x, y-1);
    addIfValid(x-1, y);
    addIfValid(x, y+1);
  }
}

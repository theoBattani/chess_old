
package fr.theo.chess.piece;

public class Bishop extends Piece {

  public Bishop(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();
    int i;
    i = 1; while (this.addIfValid(x + i, y + i)) i++;
    i = 1; while (this.addIfValid(x + i, y - i)) i++;
    i = 1; while (this.addIfValid(x - i, y + i)) i++;
    i = 1; while (this.addIfValid(x - i, y - i)) i++;
  }
}










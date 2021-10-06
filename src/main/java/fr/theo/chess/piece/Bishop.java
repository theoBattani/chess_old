
package fr.theo.chess.piece;

public class Bishop extends Piece {

  public Bishop(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();

    this.addIfValid(x+1, y+1);
    this.addIfValid(x+2, y+2);
    this.addIfValid(x+3, y+3);
    this.addIfValid(x+4, y+4);
    this.addIfValid(x+5, y+5);
    this.addIfValid(x+6, y+6);
    this.addIfValid(x+7, y+7);

    this.addIfValid(x+1, y-1);
    this.addIfValid(x+2, y-2);
    this.addIfValid(x+3, y-3);
    this.addIfValid(x+4, y-4);
    this.addIfValid(x+5, y-5);
    this.addIfValid(x+6, y-6);
    this.addIfValid(x+7, y-7);

    this.addIfValid(x-1, y+1);
    this.addIfValid(x-2, y+2);
    this.addIfValid(x-3, y+3);
    this.addIfValid(x-4, y+4);
    this.addIfValid(x-5, y+5);
    this.addIfValid(x-6, y+6);
    this.addIfValid(x-7, y+7);

    this.addIfValid(x-1, y-1);
    this.addIfValid(x-2, y-2);
    this.addIfValid(x-3, y-3);
    this.addIfValid(x-4, y-4);
    this.addIfValid(x-5, y-5);
    this.addIfValid(x-6, y-6);
    this.addIfValid(x-7, y-7);
  }
}


package fr.theo.chess.piece;


public class Rook extends Piece {

  public Rook(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();

    for (int i = 0; i < 8; i++)
      if (!this.addIfValid(x+i, y)) break;
    // this.addIfValid(x+1, y);
    // this.addIfValid(x+2, y);
    // this.addIfValid(x+3, y);
    // this.addIfValid(x+4, y);
    // this.addIfValid(x+5, y);
    // this.addIfValid(x+6, y);
    // this.addIfValid(x+7, y);

    for (int i = 0; i < 8; i++)
      if (!this.addIfValid(x-i, y)) break;
    // this.addIfValid(x-1, y);
    // this.addIfValid(x-2, y);
    // this.addIfValid(x-3, y);
    // this.addIfValid(x-4, y);
    // this.addIfValid(x-5, y);
    // this.addIfValid(x-6, y);
    // this.addIfValid(x-7, y);

    // for (int i = 0; i < 8; i++)
    //   if (!this.addIfValid(x, y+i)) break;
    this.addIfValid(x, y+1);
    this.addIfValid(x, y+2);
    this.addIfValid(x, y+3);
    this.addIfValid(x, y+4);
    this.addIfValid(x, y+5);
    this.addIfValid(x, y+6);
    this.addIfValid(x, y+7);

    for (int i = 0; i < 8; i++)
      if (!this.addIfValid(x, y-i)) break;
    // this.addIfValid(x, y-1);
    // this.addIfValid(x, y-2);
    // this.addIfValid(x, y-3);
    // this.addIfValid(x, y-4);
    // this.addIfValid(x, y-5);
    // this.addIfValid(x, y-6);
    // this.addIfValid(x, y-7);
  }
}









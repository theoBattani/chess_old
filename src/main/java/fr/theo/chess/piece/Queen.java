
package fr.theo.chess.piece;

public class Queen extends Piece {
  public Queen(Piece[] pieces, boolean white, int index) {
      super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {    
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

    this.addIfValid(x+1, y);
    this.addIfValid(x+2, y);
    this.addIfValid(x+3, y);
    this.addIfValid(x+4, y);
    this.addIfValid(x+5, y);
    this.addIfValid(x+6, y);
    this.addIfValid(x+7, y);

    this.addIfValid(x-1, y);
    this.addIfValid(x-2, y);
    this.addIfValid(x-3, y);
    this.addIfValid(x-4, y);
    this.addIfValid(x-5, y);
    this.addIfValid(x-6, y);
    this.addIfValid(x-7, y);

    this.addIfValid(x, y+1);
    this.addIfValid(x, y+2);
    this.addIfValid(x, y+3);
    this.addIfValid(x, y+4);
    this.addIfValid(x, y+5);
    this.addIfValid(x, y+6);
    this.addIfValid(x, y+7);

    this.addIfValid(x, y-1);
    this.addIfValid(x, y-2);
    this.addIfValid(x, y-3);
    this.addIfValid(x, y-4);
    this.addIfValid(x, y-5);
    this.addIfValid(x, y-6);
    this.addIfValid(x, y-7);
  }
}










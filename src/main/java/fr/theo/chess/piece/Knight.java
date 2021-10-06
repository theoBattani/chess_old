
package fr.theo.chess.piece;

public class Knight extends Piece{

  public Knight(boolean white, int index) {
    super(white, index);
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

  private boolean isValid(int x, int y) {
    return (x >= 0 && x < 8) && (y >= 0 && y < 8);
  }

  private void addIfValid(int x, int y) {
    int index = this.indexOf(x, y);
    if (isValid(x, y)) this.getValidIndices().add(index);
  }
  
}










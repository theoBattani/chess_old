
package fr.theo.chess.piece;

public class Pawn extends Piece {

  public Pawn(boolean white, int index) {
    super(white, index);
  }

  @Override
  protected void computeValidTargets() {
    this.getValidIndices().removeAll(this.getValidIndices());
    if (this.isWhite()) {
      if (this.getRankIndex() == 1) {
        this.getValidIndices().add(this.getIndex() + 8);
        this.getValidIndices().add(this.getIndex() + 16);
      }
    } 
  }
}

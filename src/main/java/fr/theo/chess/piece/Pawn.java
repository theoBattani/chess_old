
package fr.theo.chess.piece;

public class Pawn extends Piece {

  public Pawn(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {
    this.getValidIndices().removeAll(this.getValidIndices());
    if (this.isWhite()) {
      this.getValidIndices().add(this.getIndex() + 8);
      if (this.getRankIndex() == 1) {
        this.getValidIndices().add(this.getIndex() + 16);
      }
    } else {
      this.getValidIndices().add(this.getIndex() - 8);
      if (this.getRankIndex() == 6) {
        this.getValidIndices().add(this.getIndex() - 16);
      }
    }
  }
}

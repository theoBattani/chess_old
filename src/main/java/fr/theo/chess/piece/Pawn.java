
package fr.theo.chess.piece;

import fr.theo.chess.game.Game;

public class Pawn extends Piece {

  public Pawn(Game game, boolean white, int index) {
    super(game, white, index);
  }

  @Override
  protected void computeValidTargets() {
    this.getValidIndices().removeAll(this.getValidIndices());
    int enPassantTarget = game.getEnPassantTarget();
    if (this.isWhite()) {
      if (enPassantTarget != -1) {
        int thisFile = this.getFileIndex();
        int thisRank = this.getRankIndex();
        int enPassantFile = fileOf(enPassantTarget);
        int enPassantRank = rankOf(enPassantTarget);
        if (Math.abs(thisFile - enPassantFile) == 1 && enPassantRank - thisRank == 1) {
          this.getValidIndices().add(enPassantTarget);
        }
      }
      this.getValidIndices().add(this.getIndex() + 8);
      if (this.getRankIndex() == 1) {
        this.getValidIndices().add(this.getIndex() + 16);
      }
    } else {
      if (enPassantTarget != -1) {
        int thisFile = this.getFileIndex();
        int thisRank = this.getRankIndex();
        int enPassantFile = fileOf(enPassantTarget);
        int enPassantRank = rankOf(enPassantTarget);
        if (Math.abs(thisFile - enPassantFile) == 1 && enPassantRank - thisRank == -1) {
          this.getValidIndices().add(enPassantTarget);
        }
      }
      this.getValidIndices().add(this.getIndex() - 8);
      if (this.getRankIndex() == 6) {
        this.getValidIndices().add(this.getIndex() - 16);
      }
    }
  }
}


package fr.theo.chess.piece;

public abstract class Pawn extends Piece {

  int columnIndex;

  public Pawn(boolean white, int column) {
    super(white, computeIndex(white, column));
    this.columnIndex = column;
  }

  private static int computeIndex(boolean white, int column) {
    return white? column + 8: 64 - (8 - column) - 8;
  }
}

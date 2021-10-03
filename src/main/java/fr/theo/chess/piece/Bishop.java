package fr.theo.chess.piece;

public class Bishop extends Piece {

  public Bishop(boolean white, int column) {
    super(white, computeIndex(white, column));
  }


  private static int computeIndex(boolean white, int column) {
    return white? column: 64 - (8 - column); 
  }
  
  @Override protected void computeValidTarget() {
    // TODO Auto-generated method stub
  }
}

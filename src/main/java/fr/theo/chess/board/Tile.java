
package fr.theo.chess.board;

import fr.theo.chess.piece.Piece;

public class Tile {

  private int index;
  private Piece piece;

  public Tile(int index) {
    this.index = index;
    this.piece = null;
  }

  public int getIndex() {return this.index;}
  public Piece getPiece() {return this.piece;}

  public void setPiece(Piece piece) {
    this.piece = piece;
    this.piece.setTile(this);
  }

  public boolean isEmpty() {return this.piece == null;}
}











package fr.theo.chess;

import java.util.ArrayList;

import fr.theo.chess.piece.Piece;

public class ChessGame {

  private int moveIndex;
  
  private ArrayList<Piece> blackPieces;
  private ArrayList<Piece> whitePieces;

  public ChessGame() {
    this.moveIndex = 0;
    this.blackPieces = new ArrayList<Piece>();
    this.whitePieces = new ArrayList<Piece>();
  }

  public ArrayList<Piece> getBlackPieces() {return blackPieces;}
  public ArrayList<Piece> getWhitePieces() {return whitePieces;}

  
}








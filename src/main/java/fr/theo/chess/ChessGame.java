
package fr.theo.chess;

import fr.theo.chess.board.Board;
import fr.theo.chess.piece.Piece;

import java.util.ArrayList;

public class ChessGame {

  private boolean whiteDran;
  private int move;
  private Board board;
  private ArrayList<Piece> blackPieces;
  private ArrayList<Piece> whitePieces;
  private ArrayList<Piece> deadBlackPieces;
  private ArrayList<Piece> deadWhitePieces;

  public ChessGame() {
    this.whiteDran = true;
    this.move = 0;
    this.board = new Board();
    this.blackPieces = new ArrayList<Piece>();
    this.whitePieces = new ArrayList<Piece>();
    this.deadBlackPieces = new ArrayList<Piece>();
    this.deadWhitePieces = new ArrayList<Piece>();
  }

  public boolean istWhiteDran() {return this.whiteDran;}
  public int getMove() {return this.move;}
  public Board getBoard() {return this.board;}
  public ArrayList<Piece> getBlackPieces() {return blackPieces;}
  public ArrayList<Piece> getWhitePieces() {return whitePieces;}
}








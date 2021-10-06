
package fr.theo.chess;

import fr.theo.chess.piece.Piece;
import fr.theo.chess.piece.Rook;
import fr.theo.chess.piece.Knight;
import fr.theo.chess.piece.Bishop;
import fr.theo.chess.piece.Queen;
import fr.theo.chess.piece.King;
import fr.theo.chess.piece.Pawn;

import java.util.ArrayList;

public class ChessGame {

  private boolean whiteDran;
  private int move;
  private Piece[] pieces;
  private ArrayList<Piece> blackPieces;
  private ArrayList<Piece> whitePieces;
  private ArrayList<Piece> deadBlackPieces;
  private ArrayList<Piece> deadWhitePieces;

  public ChessGame() {
    this.whiteDran = true;
    this.move = 0;
    this.pieces = new Piece[64];
    this.blackPieces = new ArrayList<Piece>();
    this.whitePieces = new ArrayList<Piece>();
    this.deadBlackPieces = new ArrayList<Piece>();
    this.deadWhitePieces = new ArrayList<Piece>();
    this.initPieces();
  }

  public boolean istWhiteDran() {return this.whiteDran;}
  public int getMove() {return this.move;}
  public ArrayList<Piece> getBlackPieces() {return blackPieces;}
  public ArrayList<Piece> getWhitePieces() {return whitePieces;}
  public ArrayList<Piece> getDeadBlackPieces() {return deadBlackPieces;}
  public ArrayList<Piece> getDeadWhitePieces() {return deadWhitePieces;}
  public ArrayList<Piece> getAllPieces() {return allPieces();}
  public Piece getPieceByIndex(int index) {return this.pieces[index];}

  private ArrayList<Piece> allPieces() {
    ArrayList<Piece> output = new ArrayList<Piece>();
    output.addAll(this.blackPieces);
    output.addAll(this.whitePieces);
    return output;
  }

  private void initPieces() {
    this.initWhitePieces();
    this.initBlackPieces();
  }

  private void initBlackPieces() {
    this.pieces[56] = new Rook(false, 56);
    this.pieces[57] = new Knight(false, 57);
    this.pieces[58] = new Bishop(false, 58);
    this.pieces[59] = new Queen(false, 59);
    this.pieces[60] = new King(false, 60);
    this.pieces[61] = new Bishop(false, 61);
    this.pieces[62] = new Knight(false, 62);
    this.pieces[63] = new Rook(false, 63);
    for (int index = 48; index < 56; index++)
      this.pieces[index] = new Pawn(false, index);
    for (int index = 48; index < 64; index++)
      this.whitePieces.add(this.pieces[index]);
  }

  private void initWhitePieces() {
    this.pieces[0] = new Rook(true, 0);
    this.pieces[1] = new Knight(true, 1);
    this.pieces[2] = new Bishop(true, 2);
    this.pieces[3] = new Queen(true, 3);
    this.pieces[4] = new King(true, 4);
    this.pieces[5] = new Bishop(true, 5);
    this.pieces[6] = new Knight(true, 6);
    this.pieces[7] = new Rook(true, 7);
    for (int index = 8; index < 16; index++)
      this.pieces[index] = new Pawn(true, index);
    for (int index = 0; index < 16; index++)
      this.whitePieces.add(this.pieces[index]);
  }
}








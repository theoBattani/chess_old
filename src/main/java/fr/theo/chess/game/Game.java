
package fr.theo.chess.game;

import fr.theo.chess.piece.Piece;
import fr.theo.chess.piece.Rook;
import fr.theo.chess.piece.Knight;
import fr.theo.chess.piece.Bishop;
import fr.theo.chess.piece.Queen;
import fr.theo.chess.piece.King;
import fr.theo.chess.piece.Pawn;

import java.util.ArrayList;

public class Game {


  private Piece[] pieces;
  private ArrayList<Piece> allPieces;
  private ArrayList<Piece> blackPieces;
  private ArrayList<Piece> whitePieces;

  private boolean whiteActive = true;
  private int enPassantTarget;

  public Game() {
    this.pieces      = new Piece[64];
    this.allPieces   = new ArrayList<Piece>();
    this.blackPieces = new ArrayList<Piece>();
    this.whitePieces = new ArrayList<Piece>();
    this.enPassantTarget = -1;
    this.initPieces();
  }

  public Piece[] getPieces()               {return this.pieces;}
  public ArrayList<Piece> getBlackPieces() {return blackPieces;}
  public ArrayList<Piece> getWhitePieces() {return whitePieces;}
  public ArrayList<Piece> getAllPieces()   {return allPieces();}
  public int getEnPassantTarget()          {return this.enPassantTarget;}
  public Piece getPieceByIndex(int index)  {return this.pieces[index];}

  public boolean isWhiteActive() {return this.whiteActive;}

  public void setEnPassantTarget(int index) {this.enPassantTarget = index;}

  public void toggleActive() {whiteActive = !whiteActive;}

  private ArrayList<Piece> allPieces() {
    ArrayList<Piece> output = new ArrayList<Piece>();
    output.addAll(this.blackPieces);
    output.addAll(this.whitePieces);
    return output;
  }

  private void initPieces() {
    this.initBlackPieces();
    this.initWhitePieces();
    for (Piece piece: this.allPieces) piece.update();
  }

  private void initBlackPieces() {
    this.pieces[56] = new Rook  (this, false, 56);
    this.pieces[57] = new Knight(this, false, 57);
    this.pieces[58] = new Bishop(this, false, 58);
    this.pieces[59] = new Queen (this, false, 59);
    this.pieces[60] = new King  (this, false, 60);
    this.pieces[61] = new Bishop(this, false, 61);
    this.pieces[62] = new Knight(this, false, 62);
    this.pieces[63] = new Rook  (this, false, 63);
    for (int index = 48; index < 56; index++)
      this.pieces[index] = new Pawn(this, false, index);
    for (int index = 48; index < 64; index++) {
      this.blackPieces.add(this.pieces[index]);
      this.allPieces.add(this.pieces[index]);
    }
  }

  private void initWhitePieces() {
    this.pieces[0] = new Rook  (this, true, 0);
    this.pieces[1] = new Knight(this, true, 1);
    this.pieces[2] = new Bishop(this, true, 2);
    this.pieces[3] = new Queen (this, true, 3);
    this.pieces[4] = new King  (this, true, 4);
    this.pieces[5] = new Bishop(this, true, 5);
    this.pieces[6] = new Knight(this, true, 6);
    this.pieces[7] = new Rook  (this, true, 7);
    for (int index = 8; index < 16; index++)
      this.pieces[index] = new Pawn(this, true, index);
    for (int index = 0; index < 16; index++) {
      this.whitePieces.add(this.pieces[index]);
      this.allPieces.add(this.pieces[index]);
    }
  }
}











package fr.theo.view;

import fr.theo.chess.ChessGame;
import fr.theo.local.Assets;
import fr.theo.view.sprite.BoardView;
import fr.theo.view.sprite.PieceView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessView {

  private ChessGame game;
  private BoardView board;
  private ArrayList<PieceView> piecesList;

  private double size;
  private double tileSize;

  public ChessView(ChessGame game) {
    this.game = game;
    this.board = new BoardView(480);
    this.size = (double) 480;
    this.tileSize = this.size / 8;
    this.piecesList = new ArrayList<PieceView>();
    try {
      PieceView[] pieces = createPieces(this.tileSize);
      for (PieceView piece: pieces) {
        if (piece != null) this.piecesList.add(piece); 
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public ImageView getBoardView() {return this.board;}
  public ArrayList<PieceView> getPiecesList() {return this.piecesList;}
  public double getSize() {return this.size;}
  public double getTileSize() {return this.tileSize;}

  public PieceView getPieceAt(int index) {
    for (PieceView piece: this.piecesList) {
      if (piece.getIndex() == index) return piece;
    }
    return null;
  }

  public void resize(double size) {
    this.board.setFitWidth(size);
    this.board.setFitHeight(size);
    this.size = size;
    this.tileSize = size / 8;
    for (PieceView piece: this.piecesList) {piece.resize(this.size/8);}
  }
  
  public void dropAt(PieceView pieceView, int index) {
    if (pieceView.getPiece().getValidIndices().contains(index)) {
      pieceView.getPiece().move(index);
      pieceView.setPos();
    }
    pieceView.setPos();
  }

  private PieceView[] createPieces(double pieceSize) throws FileNotFoundException {
    PieceView[] output = new PieceView[64];
    output[0]  = (new PieceView(game.getPieceByIndex(0), pieceSize, new Image(new FileInputStream(Assets.WHITE_ROOK))));
    output[1]  = (new PieceView(game.getPieceByIndex(1), pieceSize, new Image(new FileInputStream(Assets.WHITE_KNIGHT))));
    output[2]  = (new PieceView(game.getPieceByIndex(2), pieceSize, new Image(new FileInputStream(Assets.WHITE_BISHOP))));
    output[3]  = (new PieceView(game.getPieceByIndex(3), pieceSize, new Image(new FileInputStream(Assets.WHITE_QUEEN))));
    output[4]  = (new PieceView(game.getPieceByIndex(4), pieceSize, new Image(new FileInputStream(Assets.WHITE_KING))));
    output[5]  = (new PieceView(game.getPieceByIndex(5), pieceSize, new Image(new FileInputStream(Assets.WHITE_BISHOP))));
    output[6]  = (new PieceView(game.getPieceByIndex(6), pieceSize, new Image(new FileInputStream(Assets.WHITE_KNIGHT))));
    output[7]  = (new PieceView(game.getPieceByIndex(7), pieceSize, new Image(new FileInputStream(Assets.WHITE_ROOK))));
    output[56] = (new PieceView(game.getPieceByIndex(56), pieceSize, new Image(new FileInputStream(Assets.BLACK_ROOK))));
    output[57] = (new PieceView(game.getPieceByIndex(57), pieceSize, new Image(new FileInputStream(Assets.BLACK_KNIGHT))));
    output[58] = (new PieceView(game.getPieceByIndex(58), pieceSize, new Image(new FileInputStream(Assets.BLACK_BISHOP))));
    output[59] = (new PieceView(game.getPieceByIndex(59), pieceSize, new Image(new FileInputStream(Assets.BLACK_QUEEN))));
    output[60] = (new PieceView(game.getPieceByIndex(60), pieceSize, new Image(new FileInputStream(Assets.BLACK_KING))));
    output[61] = (new PieceView(game.getPieceByIndex(61), pieceSize, new Image(new FileInputStream(Assets.BLACK_BISHOP))));
    output[62] = (new PieceView(game.getPieceByIndex(62), pieceSize, new Image(new FileInputStream(Assets.BLACK_KNIGHT))));
    output[63] = (new PieceView(game.getPieceByIndex(63), pieceSize, new Image(new FileInputStream(Assets.BLACK_ROOK))));
    for (int index = 8; index < 16; index++) 
      output[index] = (new PieceView(game.getPieceByIndex(index), pieceSize, new Image(new FileInputStream(Assets.WHITE_PAWN))));
    for (int index = 48; index < 56; index++) 
      output[index] = (new PieceView(game.getPieceByIndex(index), pieceSize, new Image(new FileInputStream(Assets.BLACK_PAWN))));
    return output;
  }
}









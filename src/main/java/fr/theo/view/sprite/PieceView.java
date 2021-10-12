
package fr.theo.view.sprite;

import fr.theo.chess.piece.Piece;
import fr.theo.util.fxutil.sprite.Sprite;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class PieceView extends Sprite {

  private int index;
  private Piece piece;
  private double size;

  public PieceView(Piece piece, double size, Image image) {
    super(image);
    this.piece = piece;
    this.index = this.piece.getIndex();
    this.resize(size);
  }

  public int getIndex() {return this.index;}
  public Piece getPiece() {return this.piece;}
  public ArrayList<Integer> getValidIndices() {return piece.getValidIndices();}

  public void setPos() {
    this.index = this.piece.getIndex();
    this.setX((this.piece.getIndex() % 8) * this.size);
    this.setY((7 - this.piece.getIndex() / 8) * this.size);
  }

  public void resize(double size) {
    this.size = size;
    this.setFitWidth(size);
    this.setFitHeight(size);
    this.setPos();
  }
}










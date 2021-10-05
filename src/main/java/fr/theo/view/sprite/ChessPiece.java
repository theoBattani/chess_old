
package fr.theo.view.sprite;

import javafx.scene.image.Image;

public class ChessPiece extends Sprite {

  private int index;
  private double size;

  public ChessPiece(int index, double size, Image image) {
    super(image);
    this.index = index;
    this.size = size;
    int rowIndex = index / 8;
    this.setX((this.index % 8) * this.size);
    this.setY((this.index / 8) * this.size);
  }
}

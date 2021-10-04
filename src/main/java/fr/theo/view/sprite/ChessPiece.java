
package fr.theo.view.sprite;

import javafx.scene.image.Image;

public class ChessPiece extends Sprite {

  private int index;

  public ChessPiece(int index, Image image) {
    super(image);
    this.index = index;
  }
}

package fr.theo.view.sprite;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ChessBoard extends Sprite {

  public ChessBoard(int size) {
    super(createImage(size));
  }

  private static Image createImage(int size) {
    WritableImage image = new WritableImage(size, size);
    PixelWriter writer = image.getPixelWriter();

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {

        writer.setColor(x, y, 
          ((int) Math.floor(x*8/size) % 2 == 0) ?
            ((int) Math.floor(y*8/size) % 2 == 0) ?
              Color.BEIGE:
              Color.GRAY:
            ((int) Math.floor(y*8/size) % 2 == 0) ?
              Color.GRAY:
              Color.BEIGE
        );
      }
    }
    return image;
  }
}

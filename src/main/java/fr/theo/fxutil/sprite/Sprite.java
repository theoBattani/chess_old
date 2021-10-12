
package fr.theo.fxutil.sprite;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Sprite extends ImageView {

  public Sprite(Image image) {
    super();
    this.setImage(image);
  }

  public Sprite(double width, double height, Image image) {
    super();
    this.setFitWidth(width);
    this.setFitHeight(height);
    this.setImage(image);
  }

  public Sprite(double width, double height, double x, double y, Image image) {
    super();
    this.setFitWidth(width);
    this.setFitHeight(height);
    this.setX(x);
    this.setY(y);
    this.setImage(image);
  }
}










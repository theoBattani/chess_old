package fr.theo.view;

import fr.theo.view.sprite.ChessBoard;
import javafx.scene.image.ImageView;

public class ChessView {

  private ChessBoard board;

  public ChessView() {
    this.board = new ChessBoard(480);
  }

  public ImageView getBoardView() {return this.board;}

  public void resize(double size) {
    this.board.setFitWidth(size);
    this.board.setFitHeight(size);

  }
}

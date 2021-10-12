
package fr.theo.view.control;

import fr.theo.chess.game.Game;

import fr.theo.fxutil.event.MouseHandler;
import fr.theo.fxutil.event.ResizeHandler;

import fr.theo.view.ChessView;
import fr.theo.view.sprite.PieceView;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ViewController {

  // Value injected by FXMLLoader
  @FXML private Stage stage;            // fx:id="stage"
  @FXML private Scene scene;            // fx:id="scene"
  @FXML private AnchorPane anchorPane;  // fx:id="anchorPane"
  @FXML private Pane pane;              // fx:id="pane"

  private Game game;
  private ChessView chessView;

  // This method is called by the FXMLLoader when initialization is complete
  @FXML void initialize() {
    assert stage != null : "fx:id=\"stage\" was not injected: check your FXML file 'view.fxml'.";
    assert scene != null : "fx:id=\"scene\" was not injected: check your FXML file 'view.fxml'.";
    
    game = new Game();
    chessView = new ChessView(game);
    pane.getChildren().add(chessView.getBoardView());
    pane.getChildren().addAll(chessView.getPiecesList());

    new ResizeHandler(scene) {
      @Override protected void onWidth(double width) {}
      @Override protected void onHeight(double height) {
        chessView.resize(height);
        stage.setMinWidth(chessView.getBoardView().getFitHeight()+16);
      }
    };

    new MouseHandler(scene) {

      PieceView selection;
      boolean select = false;
      ArrayList<Rectangle> highlights;

      {
        highlights = new ArrayList<>();
      }

      @Override
      protected void mousePressed() {
        int x = (int) Math.floor(mouseX / chessView.getTileSize());
        int y = 7 - (int) Math.floor(mouseY / chessView.getTileSize());
        int index = 8 * y + x;
        if (!select) {
          selection = chessView.getPieceAt(index);
          if (selection != null) {
            if (game.isWhiteActive() != selection.isWhite()) return;
            select = true;
            selection.setFitWidth(chessView.getTileSize() * 1.5);
            selection.setFitHeight(chessView.getTileSize() * 1.5);
            selection.setX(mouseX - selection.getFitWidth() / 2);
            selection.setY(mouseY - selection.getFitHeight() / 2);
            selection.toFront();
          }
          if (select) {
            for (int validIndex: selection.getValidIndices()) {
              highlights.add(new Rectangle(
                (validIndex % 8) * chessView.getTileSize(),
                (7 - validIndex / 8) * chessView.getTileSize(),
                chessView.getTileSize(),
                chessView.getTileSize()
              ));
              for (Rectangle square: highlights) {
                square.toFront();
                square.setFill(null);
                square.setStrokeWidth(4);
                square.setStroke(Color.BLUE);
              }
            }
            pane.getChildren().addAll(highlights);
            select = true;
          }
        }
      }

      @Override
      protected void mouseReleased() {
        int x = (int) Math.floor(mouseX / chessView.getTileSize());
        int y = 7 - (int) Math.floor(mouseY / chessView.getTileSize());
        int index = 8 * y + x;
        if (select) {
          chessView.dropAt(selection, index);
          pane.getChildren().removeAll(highlights);
          highlights.removeAll(highlights);
          selection.setFitWidth(chessView.getTileSize());
          selection.setFitHeight(chessView.getTileSize());
          select = false;
        }
      }

      @Override
      protected void mouseMoved() {}

      @Override
      protected void mouseDragged() {
          if (select) {
            selection.setX(mouseX - selection.getFitWidth() / 2);
            selection.setY(mouseY - selection.getFitHeight() / 2);
            selection.toFront();
          }
      }
    };
  }

}


package fr.theo.view.control;

import fr.theo.chess.ChessGame;
import fr.theo.view.ChessView;
import fr.theo.view.sprite.PieceView;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.beans.Observable;
import javafx.beans.binding.DoubleExpression;
import javafx.event.EventHandler;

public class ViewController {

  // Value injected by FXMLLoader
  @FXML private Stage stage;            // fx:id="stage"
  @FXML private Scene scene;            // fx:id="scene"
  @FXML private AnchorPane anchorPane;  // fx:id="anchorPane"
  @FXML private Pane pane;              // fx:id="pane"

  private ChessGame game;
  private ChessView chessView;

  // This method is called by the FXMLLoader when initialization is complete
  @FXML void initialize() {
    assert scene != null : "fx:id=\"scene\" was not injected: check your FXML file 'view.fxml'.";
    assert stage != null : "fx:id=\"stage\" was not injected: check your FXML file 'view.fxml'.";
    
    game = new ChessGame();
    chessView = new ChessView(game);
    pane.getChildren().add(chessView.getBoardView());
    pane.getChildren().addAll(chessView.getPiecesList());

    scene.widthProperty().addListener(widthProperty -> onWidth(widthProperty));
    scene.heightProperty().addListener(heightProperty -> onHeight(heightProperty));

    scene.setOnMousePressed(mouseHandler);
    scene.setOnMouseMoved(mouseHandler);
    scene.setOnMouseDragged(mouseHandler);
    scene.setOnMouseReleased(mouseHandler);
  }

  private void onWidth(Observable widthProperty) {
    // double width = ((DoubleExpression) widthProperty).getValue();
  }

  private void onHeight(Observable heightProperty) {
    double height = ((DoubleExpression) heightProperty).getValue();
    chessView.resize(height);
    stage.setMinWidth(chessView.getBoardView().getFitHeight()+16);
  }

  private EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

    double mouseX, mouseY;
    PieceView selection;
    boolean select = false;
    ArrayList<Rectangle> highlights;

    {
      highlights = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {
      mouseX = event.getX();
      mouseY = event.getY();
      if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
      }
      if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        if (select) {
          selection.setX(mouseX - chessView.getTileSize() / 2);
          selection.setY(mouseY - chessView.getTileSize() / 2);
          selection.toFront();
        }
      }
      if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
        int x = (int) Math.floor(mouseX / chessView.getTileSize());
        int y = 7 - (int) Math.floor(mouseY / chessView.getTileSize());
        int index = 8 * y + x;
        if (!select) {
          selection = chessView.getPieceAt(index);
          if (selection != null) select = true;
          if (select) {
            System.out.println(selection.getValidIndices());
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
      if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
        int x = (int) Math.floor(mouseX / chessView.getTileSize());
        int y = 7 - (int) Math.floor(mouseY / chessView.getTileSize());
        int index = 8 * y + x;
        if (select) {
          chessView.dropAt(selection, index);
          pane.getChildren().removeAll(highlights);
          highlights.removeAll(highlights);
          select = false;
        }
      }
    }
  };
}

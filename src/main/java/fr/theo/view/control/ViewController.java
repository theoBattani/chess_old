
package fr.theo.view.control;

import fr.theo.view.sprite.ChessBoard;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.beans.Observable;
import javafx.beans.binding.DoubleExpression;

public class ViewController {

  // Value injected by FXMLLoader
  @FXML private Stage stage;            // fx:id="stage"
  @FXML private Scene scene;            // fx:id="scene"
  @FXML private AnchorPane anchorPane;  // fx:id="anchorPane"
  @FXML private Pane pane;              // fx:id="pane"

  ChessBoard board;

  // This method is called by the FXMLLoader when initialization is complete
  @FXML void initialize() {
    assert scene != null : "fx:id=\"scene\" was not injected: check your FXML file 'view.fxml'.";
    assert stage != null : "fx:id=\"stage\" was not injected: check your FXML file 'view.fxml'.";
    
    board = new ChessBoard(480);
    pane.getChildren().add(board);

    scene.widthProperty().addListener(widthProperty -> onWidth(widthProperty));
    scene.heightProperty().addListener(heightProperty -> onHeight(heightProperty));
  }

  private void onWidth(Observable widthProperty) {
    // double width = ((DoubleExpression) widthProperty).getValue();
  }

  private void onHeight(Observable heightProperty) {
    double height = ((DoubleExpression) heightProperty).getValue();
    board.setFitWidth(height);
    board.setFitHeight(height);
    stage.setMinWidth(board.getFitHeight()+16);
  }
}


package fr.theo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

  @Override
  public void start(Stage s) throws IOException {
    ((Stage) (new FXMLLoader(getClass()
        .getResource("/fxml/view.fxml")
        )
      .load()
      )
    ).show();
  }

  public static void main(String[] args) {launch(args);}
}











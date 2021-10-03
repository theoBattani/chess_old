
package fr.theo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
  private static Stage stage;

  @Override
  public void start(Stage s) throws IOException {
    stage = (new FXMLLoader(getClass().getResource("/fxml/view.fxml"))).load();
    stage.show();
  }

  static void setRoot(String fxml) throws IOException {
    setRoot(fxml,stage.getTitle());
  }

  static void setRoot(String fxml, String title) throws IOException {
    Scene scene = new Scene(loadFXML(fxml));
    stage.setTitle(title);
    stage.setScene(scene);
    stage.show();
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/"+fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

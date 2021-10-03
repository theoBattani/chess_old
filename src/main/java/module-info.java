module fr.theo {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens fr.theo.view.control to javafx.fxml;
    exports fr.theo;
}
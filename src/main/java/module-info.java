module com.ramzi.audio {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.ramzi.audio to javafx.fxml;
    exports com.ramzi.audio;
}
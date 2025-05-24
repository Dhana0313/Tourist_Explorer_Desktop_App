module com.tourist_explorer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tourist_explorer to javafx.fxml;
    exports com.tourist_explorer;
}
module com.tourist_explorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.tourist_explorer to javafx.fxml;
    opens com.tourist_explorer.controllers to javafx.fxml; // 🔥 Required for your controller

    exports com.tourist_explorer;
    exports com.tourist_explorer.controllers to javafx.fxml; // Optional but good for clarity
}

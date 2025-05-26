module com.example.welcome2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.welcome2 to javafx.fxml;
    exports com.example.welcome2;
}
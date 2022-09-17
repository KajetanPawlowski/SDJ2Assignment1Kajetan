module com.example.sdj2assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    opens com.example.sdj2assignment1 to javafx.fxml;
    exports com.example.sdj2assignment1;
    exports com.example.sdj2assignment1.model;
    opens com.example.sdj2assignment1.model to javafx.fxml;
}
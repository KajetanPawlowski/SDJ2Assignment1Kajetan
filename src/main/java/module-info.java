module com.example.sdj2assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.sdj2assignment1 to javafx.fxml;
    exports com.example.sdj2assignment1;
    exports com.example.sdj2assignment1.view;
    opens com.example.sdj2assignment1.view to javafx.fxml;
}
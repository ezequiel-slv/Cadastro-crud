module com.ezequiel.cadastrocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.ezequiel.cadastrocrud to javafx.fxml;

    opens com.ezequiel.cadastrocrud.controller to javafx.fxml;

    exports com.ezequiel.cadastrocrud to javafx.graphics;
}
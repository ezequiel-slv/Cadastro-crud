module com.ezequiel.cadastrocrud {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ezequiel.cadastrocrud to javafx.fxml;
    exports com.ezequiel.cadastrocrud to javafx.graphics;
}
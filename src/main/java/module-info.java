module com.ezequiel.cadastrocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires com.google.protobuf;

    opens com.ezequiel.cadastrocrud to javafx.fxml;

    opens com.ezequiel.cadastrocrud.controller to javafx.fxml;

    opens com.ezequiel.cadastrocrud.domain to javafx.base;

    exports com.ezequiel.cadastrocrud to javafx.graphics;
}
module gui.abdullah {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens gui.abdullah to javafx.fxml;
    exports gui.abdullah;
}
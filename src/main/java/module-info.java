module com.kirbysmashyeet.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kirbysmashyeet.bmicalculator to javafx.fxml;
    exports com.kirbysmashyeet.bmicalculator;
}
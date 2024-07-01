module com.mjfelecio.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mjfelecio.bmicalculator to javafx.fxml;
    exports com.mjfelecio.bmicalculator;
}
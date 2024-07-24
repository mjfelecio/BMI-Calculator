package com.mjfelecio.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BMICalculatorController {
    @FXML
    private Label BMIDisplay;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private ToggleGroup unitGroup;
    @FXML
    private RadioButton metricUnit;
    @FXML
    private RadioButton imperialUnit;

    private String unit;

    // Imperial Units: pounds / inches
    // Metric Units: centimeters // kg
    @FXML
    public void initialize() {
        metricUnit.setToggleGroup(unitGroup);
        imperialUnit.setToggleGroup(unitGroup);
        getUnitType();
        unitGroup.selectToggle(metricUnit);
    }


    private void getUnitType() {
        unitGroup.selectedToggleProperty().addListener((ov, toggle, selectedToggle) -> {
            if (selectedToggle != null) {
                unit = ((ToggleButton) selectedToggle).getText();
                setUnit();
            }
        });
    }

    private void setUnit() {
        if (unit.equals("Metric Unit")) {
            heightField.setPromptText("cm");
            weightField.setPromptText("kg");
        }
        else if (unit.equals("Imperial Unit")) {
            heightField.setPromptText("in");
            weightField.setPromptText("lbs");
        }
    }


    @FXML
    private void getHeight() {

    }

    @FXML
    private void getWeight() {

    }

    @FXML
    private void getUnit() {

    }

    @FXML
    private void displayController() {

    }

    @FXML
    private void displayExtraInfo() {

    }
}
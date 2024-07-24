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
    @FXML
    private Button calculateBMIButton;

    private String unitUsed;
    
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
                unitUsed = ((ToggleButton) selectedToggle).getText();
                setUnit();
            }
        });
    }

    private void setUnit() {
        if (unitUsed.equals("Metric Unit")) {
            heightField.setPromptText("cm");
            weightField.setPromptText("kg");
        }
        else if (unitUsed.equals("Imperial Unit")) {
            heightField.setPromptText("in");
            weightField.setPromptText("lbs");
        }
    }

    @FXML
    private void calculateBMI() {
        calculateBMIButton.setOnAction(e -> System.out.println("Calculate it"));
    }

    @FXML
    private void getHeight() {

    }

    @FXML
    private void getWeight() {

    }

    @FXML
    private void displayController() {

    }

    @FXML
    private void displayExtraInfo() {

    }
}
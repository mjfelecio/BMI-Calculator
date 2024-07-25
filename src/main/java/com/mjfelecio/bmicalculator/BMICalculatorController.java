package com.mjfelecio.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.util.function.UnaryOperator;

public class BMICalculatorController {
    @FXML
    private Label BMIDisplay;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;


    private String unitUsed;
    @FXML
    private ToggleGroup unitGroup;
    @FXML
    private RadioButton metricUnit;
    @FXML
    private RadioButton imperialUnit;


    @FXML
    private Button calculateBMIButton;


    
    @FXML
    public void initialize() {
        metricUnit.setToggleGroup(unitGroup);
        imperialUnit.setToggleGroup(unitGroup);
        getUnitType();
        unitGroup.selectToggle(metricUnit);

        setupInputFilter(heightField);
        setupInputFilter(weightField);
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
        calculateBMIButton.setOnAction(e -> {
            double height = getHeight();
            double weight = getWeight();


        });
    }

    private double getHeight() {
        return Double.parseDouble(heightField.getText());
    }

    private double getWeight() {
        return Double.parseDouble(weightField.getText());
    }

    private void setupInputFilter(TextField textField) {
        // Create a filter that allows only numeric numbers, decimal numbers, and empty characters
        String regex = "^\\d*\\.?\\d*$";

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches(regex)) {
                return change;
            }
            return null;
        };

        StringConverter<Double> converter = new DoubleStringConverter();

        TextFormatter<Double> textFormatter = new TextFormatter<>(converter, null, filter);
        // formats the text input based on the filter provided

        textField.setTextFormatter(textFormatter);
    }


    @FXML
    private void displayController() {

    }

    @FXML
    private void displayExtraInfo() {

    }
}
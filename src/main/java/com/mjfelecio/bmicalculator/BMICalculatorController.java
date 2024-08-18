package com.mjfelecio.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.util.function.UnaryOperator;

public class BMICalculatorController {

    BMI bmiCalculator;

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

    private String selectedUnit;
    private double meters;
    private double kilograms;

    public void initialize() {
        bmiCalculator = new BMI();
        setupToggleButtons();
        setupInputFilter(heightField);
        setupInputFilter(weightField);

        // Sets metric as default unit
        unitGroup.selectToggle(metricUnit);
        selectedUnit = "Metric Unit";
    }

    @FXML
    private void calculateBMI() {
        convertInputToMeterAndKG();

        bmiCalculator.setHeight(meters);
        bmiCalculator.setWeight(kilograms);
        bmiCalculator.calculateBMI();
        updateBMIDisplay();
    }

    private void updateBMIDisplay() {
        String bmi = bmiCalculator.getBMI();
        String bmiCategory = bmiCalculator.getBMICategory();
        BMIDisplay.setText("BMI: " + bmi + "\n" + "BMI Category: " + bmiCategory);
    }

    private void setupToggleButtons() {
        metricUnit.setToggleGroup(unitGroup);
        imperialUnit.setToggleGroup(unitGroup);

        unitGroup.selectedToggleProperty().addListener((_, _, selectedToggle) -> {
            if (selectedToggle != null) {
                String unitUsed = ((ToggleButton)selectedToggle).getText();
                setUnit(unitUsed);
            }
        });
    }

    private void setUnit(String unit) {
        if (unit.equals("Metric Unit")) {
            heightField.setPromptText("cm");
            weightField.setPromptText("kg");
            selectedUnit = "Metric Unit";
        }
        else if (unit.equals("Imperial Unit")) {
            heightField.setPromptText("in");
            weightField.setPromptText("lbs");
            selectedUnit = "Imperial Unit";
        }
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

    private void convertInputToMeterAndKG() {
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());

        if (selectedUnit.equals("Metric Unit")) {
            meters = height/100;
            kilograms = weight;

        } else if (selectedUnit.equals("Imperial Unit")) {
            double inches = height;
            meters = inches * 0.0254;

            double pounds = weight;
            kilograms = pounds * 0.45359237;
        }
    }
}
package com.mjfelecio.bmicalculator;

public class BMI {
    private double heightInM;
    private double weightInKG;
    private double BMI;

    public BMI() {
        this.heightInM = 0;
        this.weightInKG = 0;
        this.BMI = 0;
    }

    public void setHeight(double height) {
        this.heightInM = height;
    }

    public void setWeight(double weight) {
        this.weightInKG = weight;
    }

    public String getBMI() {
        return String.valueOf(Math.round(BMI * 10)/10.0);
    }

    public String getBMICategory() {
        if (this.BMI < 18.5) {
            return "Underweight";
        }
        else if (this.BMI < 25) {
            return "Normal";
        }
        else if (this.BMI < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public void calculateBMI() {
        double meterSquared = this.heightInM * this.heightInM;
        double kilogram = this.weightInKG;

        this.BMI = kilogram / meterSquared;
    }
}

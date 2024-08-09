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

    public void calculateBMI() {
        double meterSquared = this.heightInM * this.heightInM;
        double kilogram = this.weightInKG;

        this.BMI = kilogram / meterSquared;
    }

    public String getBMI() {
        return String.valueOf(Math.round(BMI * 10)/10.0);
    }
}

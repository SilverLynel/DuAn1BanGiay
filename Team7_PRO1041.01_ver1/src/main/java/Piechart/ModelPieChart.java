package Piechart;

import java.awt.Color;

public class ModelPieChart {

    private String name;
    private double values;
    private double totalMoney;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModelPieChart() {
    }


    public ModelPieChart(String name, double values, double totalMoney, Color color) {
        this.name = name;
        this.values = values;
        this.totalMoney = totalMoney;
        this.color = color;
    }


}

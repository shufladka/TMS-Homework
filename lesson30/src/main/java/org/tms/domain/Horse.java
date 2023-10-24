package org.tms.domain;

public class Horse {

    private String name;               // кличка лошади
    private double speedCoef;          // коэффициент скорости

    public Horse(String name, double speedCoef) {
        this.name = name;
        this.speedCoef = speedCoef;
    }

    public String getName() {
        return name;
    }

    public double getSpeedCoef() {
        return speedCoef;
    }

    public void setSpeedCoef(double speedCoef) {
        this.speedCoef = speedCoef;
    }

    @Override
    public String toString() {
        return "лошадь '" + name + "'";
    }
}
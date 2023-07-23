package org.tms.office;

public enum EnumPosition {
    DIRECTOR("Директор"),
    ACCOUNTANT("Бухгалтер"),
    WORKER("Рабочий");

    private final String position;

    EnumPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}

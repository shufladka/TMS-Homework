package org.tms.structure;

public enum Staff {

    DIRECTOR (1850, 1.33, 1.0),
    WORKER (1400,1.0, 1.0);

    public int baseRate;              // базовая ставка
    public double multiplyingFactor;  // повышающий коэффициент
    public double workExperienceMF;   // повышающий коэффициент за стаж работы

    Staff(int baseRate, double multiplyingFactor, double workExperienceMF) {
        this.baseRate = baseRate;
        this.multiplyingFactor = multiplyingFactor;
        this.workExperienceMF = workExperienceMF;
    }

    public int getBaseRate() {
        return baseRate;
    }

    public double getMultiplyingFactor() {
        return multiplyingFactor;
    }

    public double getWorkExperienceMF() {
        return workExperienceMF;
    }
}

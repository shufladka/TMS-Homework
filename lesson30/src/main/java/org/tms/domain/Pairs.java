package org.tms.domain;

public class Pairs {

    private Jokey jokey;    // данный жокей
    private Horse horse;    // лошадь данного жокея

    public Pairs(Jokey jokey, Horse horse) {
        this.jokey = jokey;
        this.horse = horse;
    }

    public Jokey getJokey() {
        return jokey;
    }

    public void setJokey(Jokey jokey) {
        this.jokey = jokey;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public String toString() {
        return "пара: " + jokey.toString() + ", " + horse.toString();
    }
}
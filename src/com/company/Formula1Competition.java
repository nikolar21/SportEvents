package com.company;

public class Formula1Competition implements Competition {
    private double winnersTime;
    Participant[] schedule;

    public Formula1Competition() {}

    public double getWinnersTime() {
        return winnersTime;
    }

    public void setWinnersTime(double winnersTime) {
        this.winnersTime = winnersTime;
    }

    @Override
    public Participant[] getSchedule() {
        return schedule;
    }

    public void setSchedule(Participant[] schedule) {
        this.schedule = schedule;
    }
}

package com.company;

public class FootballCompetition implements Competition {
    private double fastestGoal;
    Participant[] schedule;

    public FootballCompetition() {}

    public double getFastestGoal() {
        return fastestGoal;
    }

    public void setFastestGoal(double fastestGoal) {
        this.fastestGoal = fastestGoal;
    }

    @Override
    public Participant[] getSchedule() {
        return schedule;
    }

    public void setSchedule(Participant[] schedule) {
        this.schedule = schedule;
    }
}

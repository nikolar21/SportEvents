package com.company;

public class HorseCompetition implements Competition {
    private String breed;
    Participant[] schedule;

    public HorseCompetition() {}

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public Participant[] getSchedule() {
        return schedule;
    }

    public void setSchedule(Participant[] schedule) {
        this.schedule = schedule;
    }
}

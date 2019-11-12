package com.company;

public class CreateEvent {
    private String typeOfEvent;

    Competition getEvent(String competitionType) throws NoSuchEventException {

        /**
         * This cannot represent actual type for determining the incoming competition object
         * due to abstract implementation, it was probably the main purpose and it is wrong.
         */
        typeOfEvent = competitionType;

        if (competitionType.equals("Football")) {
            return new FootballCompetition();
        } else if (competitionType.equals("Horse")) {
            return new HorseCompetition();
        } else if (competitionType.equals("Formula1")) {
            return new Formula1Competition();
        } else {
            throw new NoSuchEventException("NEMA");
        }
    }


    /**
     * Safer way of implementing fill Schedule method using instance of keyword to determine
     * abstract objects origin. The only gap in this sample is unused typeOfEvent field which
     * was probably thought of using for determining abstract objects origin
     */
    public void fillsSchedule(Competition competition, Participant[] schedule) throws EmptySetException {
        if(schedule.length == 0) {
            throw new EmptySetException("Schedule must contain at least one participant");
        }

        if(competition instanceof Formula1Competition) {
            Formula1Competition formula1Competition = (Formula1Competition)competition;
            formula1Competition.setSchedule(schedule);
        } else if(competition instanceof HorseCompetition) {
            HorseCompetition horseCompetition = (HorseCompetition)competition;
            horseCompetition.setSchedule(schedule);
        } else if(competition instanceof FootballCompetition) {
            FootballCompetition footballCompetition = (FootballCompetition)competition;
            footballCompetition.setSchedule(schedule);
        }

    }

    /**
     * Probably expected way of implementing fillSchedule method with usage of internal variable
     * This needs to be used with caution in main class when calling fillSchedule due to hard-coded value of
     * typeOfEvent field, which may end with {@link ClassCastException}
     *
     * public void fillsSchedule(Competition competition, Participant[] schedule) throws EmptySetException {
     *
     *         if (schedule.length == 0) {
     *             throw new EmptySetException("Schedule must contain at least one participant");
     *         }
     *
     *         if (typeOfEvent.equals("Formula1")) {
     *             Formula1Competition formula1Competition = (Formula1Competition) competition;
     *             formula1Competition.setSchedule(schedule);
     *         } else if (typeOfEvent.equals("Horse")) {
     *             ((HorseCompetition) competition).setSchedule(schedule);
     *         } else if (typeOfEvent.equals("Football")) {
     *             FootballCompetition footballCompetition = (FootballCompetition) competition;
     *             footballCompetition.setSchedule(schedule);
     *         }
     *     }
     *
     */


    static void bets(Competition competition, int id, double bet) {
        Participant[] participants = competition.getSchedule();
        for(Participant participant: participants) {
            if(participant.getId() == id) {
                double betToWin = participant.getBetForWin();
                double chanceToWin = participant.getChanceToWin();
                chanceToWin -= (bet + betToWin) / betToWin;
                participant.setChanceToWin(chanceToWin < 1.1 ? 1.1 : chanceToWin);
            }
        }
    }

}


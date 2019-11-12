package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchEventException, EmptySetException {
		CreateEvent createEvent = new CreateEvent();

		Participant[] footballParticipants = new Participant[3];
		footballParticipants[0] = new Participant(1,"Manchester",25,4,500);
		footballParticipants[1] = new Participant(2,"Real Madrid",20,1.5,500);
		footballParticipants[2] = new Participant(3,"Barcelona",23,1.5,500);

		Participant[] horseParticipants = new Participant[3];
		Participant[] formula1Participants = new Participant[3];

		Competition footballObj = createEvent.getEvent("Football");
		Competition horseObj = createEvent.getEvent("Horse");
		Competition formulaObj = createEvent.getEvent("Formula1");

		/**
		 * Do not use this calls for second approach which was commented in {@link CreateEvent}
		 */
		createEvent.fillsSchedule(footballObj, footballParticipants);
		createEvent.fillsSchedule(horseObj, horseParticipants);
		createEvent.fillsSchedule(formulaObj, formula1Participants);


		CreateEvent.bets(footballObj, 1, 50);
		CreateEvent.bets(footballObj, 1, 50);
		CreateEvent.bets(footballObj, 1, 50);

		/**
		 * Here we see that calling bets three times on {@link Participant} with id = 1
		 * will decrement chanceToWin field under minimal allowed (1.1) so it should be set to 1.1
		 * Other ones stay untouched (1.5)
		 * Here you can play around with betting other participants for this or any other {@link Competition}
		 * and see the actual output in the end
		 */
		System.out.println(Arrays.toString(footballObj.getSchedule()));

	}
}

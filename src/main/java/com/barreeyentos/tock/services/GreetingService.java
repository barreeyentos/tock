package com.barreeyentos.tock.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import com.barreeyentos.tock.dtos.Greeting;

@Service
public class GreetingService {

	public static final String INVALID_HOUR = "You should really fix the clock.";
	public static final String GOOD_NIGHT = "Good night";
	public static final String GOOD_AFTERNOON = "Good afternoon";
	public static final String GOOD_MORNING = "Good morning!";
	public static final String NIGHT_OWL = "Good morning?";

	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	private TimeService timeService;

	public GreetingService(TimeService timeService) {
		this.timeService = timeService;
	}

	public Greeting createAppropriateGreeting() {
		String greeting = null;
		LocalDateTime localDateTime = timeService.now();
		String formattedTime = localDateTime.format(formatter);

		int hour = localDateTime.getHour();

		if (0 <= hour && hour <= 5) {
			greeting = NIGHT_OWL;
		} else if (6 <= hour && hour <= 11) {
			greeting = GOOD_MORNING;
		} else if (12 <= hour && hour <= 17) {
			greeting = GOOD_AFTERNOON;
		} else if (18 <= hour && hour <= 23) {
			greeting = GOOD_NIGHT;
		} else {
			greeting = INVALID_HOUR;
		}

		return new Greeting(greeting, formattedTime);
	}
}

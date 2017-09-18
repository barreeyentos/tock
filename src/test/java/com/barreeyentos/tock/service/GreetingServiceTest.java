package com.barreeyentos.tock.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.barreeyentos.tock.Tock;
import com.barreeyentos.tock.dtos.Greeting;
import com.barreeyentos.tock.services.GreetingService;

public class GreetingServiceTest {

	private GreetingService service;
	private Tock tock;

	@Before
	public void before() {
		tock = new Tock();
		service = new GreetingService(tock);
	}

	@Test
	public void testMorning() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 9, 30));

		Greeting greeting = service.createAppropriateGreeting();

		assertThat(greeting.getGreeting()).isEqualTo(GreetingService.GOOD_MORNING);
	}

	@Test
	public void testNightOwl() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 2, 30));

		Greeting greeting = service.createAppropriateGreeting();

		assertThat(greeting.getGreeting()).isEqualTo(GreetingService.NIGHT_OWL);
	}

	@Test
	public void testAfternoon() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 13, 30));

		Greeting greeting = service.createAppropriateGreeting();

		assertThat(greeting.getGreeting()).isEqualTo(GreetingService.GOOD_AFTERNOON);
	}

	@Test
	public void testNight() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 21, 30));

		Greeting greeting = service.createAppropriateGreeting();

		assertThat(greeting.getGreeting()).isEqualTo(GreetingService.GOOD_NIGHT);
	}
}

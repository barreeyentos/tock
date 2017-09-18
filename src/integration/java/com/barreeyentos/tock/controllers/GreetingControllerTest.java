package com.barreeyentos.tock.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.barreeyentos.tock.Application;
import com.barreeyentos.tock.Tock;
import com.barreeyentos.tock.dtos.Greeting;
import com.barreeyentos.tock.services.GreetingService;
import com.barreeyentos.tock.services.TimeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

	@Configuration
	@Import(Application.class) // the actual configuration
	public static class TestConfig {
		@Bean
		public TimeService timeService() {
			return new Tock();
		}
	}

	@Autowired
	@Qualifier("timeService")
	private Tock tock;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testMorning() throws Exception {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 9, 30));

		Greeting result = this.restTemplate.getForObject("/greeting", Greeting.class);

		assertThat(result.getGreeting()).isEqualTo(GreetingService.GOOD_MORNING);
	}

	@Test
	public void testNightOwl() throws Exception {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 2, 30));

		Greeting result = this.restTemplate.getForObject("/greeting", Greeting.class);

		assertThat(result.getGreeting()).isEqualTo(GreetingService.NIGHT_OWL);
	}

	@Test
	public void testAfternoon() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 13, 30));

		Greeting result = this.restTemplate.getForObject("/greeting", Greeting.class);

		assertThat(result.getGreeting()).isEqualTo(GreetingService.GOOD_AFTERNOON);
	}

	@Test
	public void testNight() {
		tock.setTime(LocalDateTime.of(2017, Month.SEPTEMBER, 17, 21, 30));

		Greeting result = this.restTemplate.getForObject("/greeting", Greeting.class);

		assertThat(result.getGreeting()).isEqualTo(GreetingService.GOOD_NIGHT);
	}
}

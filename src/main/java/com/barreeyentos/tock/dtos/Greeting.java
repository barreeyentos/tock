package com.barreeyentos.tock.dtos;

public class Greeting {
	private String greeting;
	private String dateTime;

	public Greeting() {
	}

	public Greeting(String greeting, String dateTime) {
		this.setGreeting(greeting);
		this.setDateTime(dateTime);
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}

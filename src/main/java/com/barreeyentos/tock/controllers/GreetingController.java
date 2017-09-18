package com.barreeyentos.tock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.barreeyentos.tock.dtos.Greeting;
import com.barreeyentos.tock.services.GreetingService;

@Controller
@RequestMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GreetingController {

	private GreetingService service;

	@Autowired
	public GreetingController(GreetingService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public Greeting greetMe() {
		return service.createAppropriateGreeting();
	}
}

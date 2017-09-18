package com.barreeyentos.tock.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("timeService")
public class TimeServiceImpl implements TimeService {

	public LocalDateTime now() {
		return LocalDateTime.now();
	}
}

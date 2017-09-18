package com.barreeyentos.tock;

import java.time.LocalDateTime;
import java.util.Objects;

import com.barreeyentos.tock.services.TimeService;

public class Tock implements TimeService {
	private LocalDateTime mockTime;

	public Tock() {
	}

	public void setTime(LocalDateTime now) {
		this.mockTime = now;
	}

	@Override
	public LocalDateTime now() {
		if (Objects.isNull(mockTime)) {
			return LocalDateTime.now();
		}
		return mockTime;
	}

}

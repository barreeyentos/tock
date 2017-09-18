package com.barreeyentos.tock.services;

import java.time.LocalDateTime;

@FunctionalInterface
public interface TimeService {
	LocalDateTime now();
}

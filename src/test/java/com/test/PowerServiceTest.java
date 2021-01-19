package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.PowerService;

@SpringBootTest
public class PowerServiceTest {

	@Autowired
	private PowerService powerService;

	@Test
	public void shouldBeAbleToCheckIfANumberIsPowerOf2() {

		boolean result = powerService.isPowerOfTwo(256);
		assertTrue(result);
	}
}

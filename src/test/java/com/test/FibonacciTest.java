package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.FibonacciService;

@SpringBootTest
public class FibonacciTest {

	@Autowired
	private FibonacciService fibonacciService;

	@Test
	public void shouldBeAbleToPrintFibonacciSequence() {
		// Actual result
		List<Integer> sequenceList = fibonacciService.printFibonacciSeries(9);

		// Expected result
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(5);
		expectedList.add(8);
		expectedList.add(13);
		expectedList.add(21);
		expectedList.add(34);

		// Assertion
		assertEquals(expectedList, sequenceList);
	}
}

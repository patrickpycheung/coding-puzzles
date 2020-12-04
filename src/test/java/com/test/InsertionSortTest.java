package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.InsertionSortService;

@SpringBootTest
public class InsertionSortTest {

	@Autowired
	private InsertionSortService insertionSortService;

	@Test
	public void shouldBeAbleToDoInsertionSort() {
		List<Integer> inputList = new ArrayList<>();
		inputList.add(2);
		inputList.add(1);
		inputList.add(3);

		// Actual result
		List<Integer> resultList = insertionSortService.doInsertionSort(inputList);

		// Expected result
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);

		// Assertion
		assertEquals(expectedList, resultList);
	}
}

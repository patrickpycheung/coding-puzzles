package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.FloydTriangleService;

@SpringBootTest
public class FloydTriangeTest {

	@Autowired
	private FloydTriangleService floydTriangleService;

	@Test
	public void shouldBeAbleToPrintFloydTriangle() {
		List<Integer> inputList = new ArrayList<>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(4);
		inputList.add(5);
		inputList.add(6);
		inputList.add(7);
		inputList.add(8);
		inputList.add(9);
		inputList.add(10);

		// Actual result
		List<String> rowStrList = floydTriangleService.printFloydTriangle(inputList);

		// Expected result
		List<String> expectedRowStrList = new ArrayList<>();
		expectedRowStrList.add("1");
		expectedRowStrList.add("2 3");
		expectedRowStrList.add("4 5 6");
		expectedRowStrList.add("7 8 9 10");

		// Assertion
		assertEquals(expectedRowStrList, rowStrList);
	}
}

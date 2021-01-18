package com.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.ReplaceSpaceService;

@SpringBootTest
public class ReplaceSpaceServiceTest {

	@Autowired
	private ReplaceSpaceService replaceSpaceService;

	@Test
	public void shouldBeAbleToReplaceSpaces() {

		// Input

		char[] str = new char[20];
		str[0] = '1';
		str[1] = ' ';
		str[2] = '2';
		str[3] = ' ';
		str[4] = '3';

		// Actual result

		char[] resultStr = replaceSpaceService.replaceSpaces(str, 5);

		// Expected result

		char[] expectedStr = new char[20];
		expectedStr[0] = '1';
		expectedStr[1] = '%';
		expectedStr[2] = '2';
		expectedStr[3] = '0';
		expectedStr[4] = '2';
		expectedStr[5] = '%';
		expectedStr[6] = '2';
		expectedStr[7] = '0';
		expectedStr[8] = '3';

		// Assertion

		assertThat(Arrays.equals(expectedStr, resultStr));
	}
}

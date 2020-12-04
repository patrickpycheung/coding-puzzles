package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.PalindromeService;

@SpringBootTest
public class PalindromeTest {

	@Autowired
	private PalindromeService palindromeService;

	@Test
	public void shouldBeAbleToCheckIfAStringIsPalindrome() {
		boolean isPalinDrome = palindromeService.isPalindrome("aba");
		assertEquals(true, isPalinDrome);

		isPalinDrome = palindromeService.isPalindrome("abba");
		assertEquals(true, isPalinDrome);

		isPalinDrome = palindromeService.isPalindrome("abcd");
		assertEquals(false, isPalinDrome);
	}
}

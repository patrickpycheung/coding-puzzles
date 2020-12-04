package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

	public boolean isPalindrome(String inputStr) {
		char[] charArr = inputStr.toCharArray();

		for (int i = 0; i <= charArr.length / 2 - 1; i++) {
			// Check if characters at the two sides match
			if (!(charArr[i] == charArr[charArr.length - 1 - i])) {
				// Pattern not match
				return false;
			}
		}

		return true;
	}
}

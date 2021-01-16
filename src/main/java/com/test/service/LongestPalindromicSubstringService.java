package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class LongestPalindromicSubstringService {

	public static String longestPalindrome(String s) {

		// Convert to char array
		char[] charArr = s.toCharArray();

		int maxLength = 0;
		String maxPalindrome = "";

		for (int i = 1; i <= charArr.length - 2; i++) {

			String currentPalindrome = String.valueOf(charArr[i]);
			int currentLength = 0;

			int lowerBound = i - 1;
			int upperBound = i + 1;

			while (lowerBound >= 0 && upperBound <= charArr.length - 1) {
				if (charArr[lowerBound] == charArr[upperBound]) {
					// Is panlidrome pattern

					// Update the accumulated length of palindrome
					currentLength += 2;
					// Update the panlindrome
					currentPalindrome = String.valueOf(charArr[lowerBound]).concat(currentPalindrome)
							.concat(String.valueOf(charArr[upperBound]));

					lowerBound--;
					upperBound++;
				} else {
					break;
				}
			}

			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxPalindrome = currentPalindrome;
			}
		}

		return maxPalindrome;
	}

	public static void main(String args[]) {
		String longestPalindrome = longestPalindrome("cabadexxxyxxxg");
		System.out.println(longestPalindrome);
	}
}

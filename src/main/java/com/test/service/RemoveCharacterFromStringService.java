package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class RemoveCharacterFromStringService {

	public static String removeCharInString(String str, char charToBeRemoved) {

		char[] charArr = str.toCharArray();

		StringBuilder sb = new StringBuilder();

		for (char ch : charArr) {
			if (ch == charToBeRemoved) {
				continue;
			}

			sb.append(ch);
		}

		return sb.toString();
	}

	public static void main(String args[]) {
		String editedStr = removeCharInString("My name is the Doctor", 'a');
		System.out.println(editedStr);
	}
}

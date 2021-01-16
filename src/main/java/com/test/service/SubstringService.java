package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class SubstringService {

	public static boolean hasSubstring(String str, String findStr) {
		if (str.contains(findStr)) {
			return true;
		}

		return false;
	}

	public static void main(String args[]) {
		System.out.println(hasSubstring("abate", "bat"));
		System.out.println(hasSubstring("beat", "bat"));
	}
}

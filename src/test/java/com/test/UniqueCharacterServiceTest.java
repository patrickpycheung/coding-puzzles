package com.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.UniqueCharacterService;

@SpringBootTest
public class UniqueCharacterServiceTest {

	@Autowired
	private UniqueCharacterService uniqueCharacterService;

	@Test
	public void shouldBeAbleToCheckIfAStringIsComposedOfUniqueCharacters() {

		boolean result = uniqueCharacterService.isUniqueChars("abc");
		assertTrue(result);

		result = uniqueCharacterService.isUniqueChars("aba");
		assertFalse(result);
	}
}

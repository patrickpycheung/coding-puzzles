package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.service.binaryTreeService.BinaryTree;

@Configuration
public class CodingPuzzlesConfig {

	@Bean
	public BinaryTree getBinaryTree() {
		BinaryTree binaryTree = new BinaryTree();
		return binaryTree;
	}
}

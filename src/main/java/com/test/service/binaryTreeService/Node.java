package com.test.service.binaryTreeService;

import lombok.Data;

@Data
public class Node {

	private int value;
	private Node leftNode;
	private Node rightNode;

	public Node() {
		super();
	}

	public Node(int value) {
		this.value = value;
	}
}

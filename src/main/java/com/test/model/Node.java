package com.test.model;

import lombok.Data;

@Data
public class Node {

	private int value;
	private Node leftNode;
	private Node rightNode;
}
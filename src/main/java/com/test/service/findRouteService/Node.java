package com.test.service.findRouteService;

import java.util.List;

import lombok.Data;

@Data
public class Node {
	private State state;

	private int value;

	private List<Node> nextNodes;

	public Node() {
		super();
	}

	public Node(int value) {
		this.value = value;
	}
}

enum State {
	UNVISITED, VISITED;
}

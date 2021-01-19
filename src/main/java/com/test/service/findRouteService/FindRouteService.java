package com.test.service.findRouteService;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class FindRouteService {

	public boolean search(Graph g, Node start, Node end) {

		// Initialize all the nodes

		for (Node node : g.getNodes()) {
			node.setState(State.UNVISITED);
		}

		// Add start node to list

		LinkedList<Node> nodeList = new LinkedList<>();
		nodeList.add(start);

		// Trace down from the start node

		Node currentNode;

		while (!nodeList.isEmpty()) {
			// Do as long as there are still elements in the list

			currentNode = nodeList.removeFirst();

			for (Node node : currentNode.getNextNodes()) {

				if (node == end) {
					// Is the target element

					return true;
				}

				// Not yet reached target element

				if (nodeList.contains(node)) {
					// Already have the element in the list

					continue;
				} else {
					// Not yet have the element in the list

					node.setState(State.VISITED);
					nodeList.add(node);
				}
			}
		}

		return false;
	}
}

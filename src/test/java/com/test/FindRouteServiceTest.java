package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.findRouteService.FindRouteService;
import com.test.service.findRouteService.Graph;
import com.test.service.findRouteService.Node;

@SpringBootTest
public class FindRouteServiceTest {

	@Autowired
	private FindRouteService findRouteService;

	@Test
	public void shoudBeAbleToDetermineIfARouteExistBetweenTwoNodes() {

		// Input

		Node node01 = new Node(1);
		Node node02 = new Node(2);
		Node node03 = new Node(3);
		Node node04 = new Node(4);
		Node node05 = new Node(5);
		Node node06 = new Node(6);
		Node node07 = new Node(7);
		Node node08 = new Node(8);
		Node node09 = new Node(9);

		// Configure the node network

		LinkedList<Node> nodeList01 = new LinkedList<>();
		nodeList01.add(node02);
		nodeList01.add(node04);

		LinkedList<Node> nodeList02 = new LinkedList<>();
		nodeList02.add(node03);
		nodeList02.add(node05);

		LinkedList<Node> nodeList03 = new LinkedList<>();
		nodeList03.add(node06);

		LinkedList<Node> nodeList04 = new LinkedList<>();
		nodeList04.add(node05);
		nodeList04.add(node07);

		LinkedList<Node> nodeList05 = new LinkedList<>();
		nodeList05.add(node06);
		nodeList05.add(node08);

		LinkedList<Node> nodeList06 = new LinkedList<>();
		nodeList06.add(node09);

		LinkedList<Node> nodeList07 = new LinkedList<>();
		nodeList07.add(node08);

		LinkedList<Node> nodeList08 = new LinkedList<>();
		nodeList08.add(node09);

		node01.setNextNodes(nodeList01);
		node02.setNextNodes(nodeList02);
		node03.setNextNodes(nodeList03);
		node04.setNextNodes(nodeList04);
		node05.setNextNodes(nodeList05);
		node06.setNextNodes(nodeList06);
		node07.setNextNodes(nodeList07);
		node08.setNextNodes(nodeList08);

		// Build graph

		LinkedList<Node> allNodeList = new LinkedList<>();
		allNodeList.add(node01);
		allNodeList.add(node02);
		allNodeList.add(node03);
		allNodeList.add(node04);
		allNodeList.add(node05);
		allNodeList.add(node06);
		allNodeList.add(node07);
		allNodeList.add(node08);
		allNodeList.add(node09);

		Graph graph = new Graph();
		graph.setNodes(allNodeList);

		// Actual result

		boolean result = findRouteService.search(graph, node01, node09);

		// Assertion

		assertTrue(result);
	}
}

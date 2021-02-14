import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	private Graph.Node endNode;
	private Graph.Node startNode;
	PriorityQueue<Graph.Node> queue = new PriorityQueue<Graph.Node>((node1, node2) -> {
		if (node1.getDistance() == node2.getDistance()) {
			return node1.getId() - node2.getId();
		}
		return node1.getDistance() - node2.getDistance();
	});

	public Dijkstra() {

	}

	public void findRoute(Graph g, Graph.Node a, Graph.Node b) {
		endNode = b;

		for (Graph.Node node : g.getNodes()) {
			node.setDistance(Integer.MAX_VALUE);
		}

		a.setDistance(0);
		a.setParent(null);
		queue.add(a);
		do {
			Graph.Node currentNode = queue.poll();
			if (currentNode.getWeightsOfOutgoingNodes() != null) {
				for (int i = 0; i < currentNode.getWeightsOfOutgoingNodes().size(); i++) {
					if (currentNode.getWeightsOfOutgoingNodes().get(i) >= 0) {
						int newDistance = currentNode.getDistance() + currentNode.getWeightsOfOutgoingNodes().get(i);
						if (newDistance < g.getNode(i).getDistance()) {
							g.getNode(i).setParent(currentNode);
							if (g.getNode(i).getDistance() != Integer.MAX_VALUE) {
								queue.remove(g.getNode(i));
							}
							g.getNode(i).setDistance(newDistance);
							queue.add(g.getNode(i));
						}
					}
				}
			}
		} while (!queue.isEmpty());
	}

	public List<Graph.Node> getShortestPath() {
		List<Graph.Node> nodes = new ArrayList<Graph.Node>();
		if (endNode.getParent() == null) {
			if (endNode.equals(startNode)) {
				nodes.add(endNode);
			}
			return nodes;
		}

		Graph.Node currentNode = endNode;
		while (currentNode != null) {
			nodes.add(currentNode);
			currentNode = currentNode.getParent();
		}
		List<Graph.Node> nodesReverse = new ArrayList<Graph.Node>(nodes.size());
		for (int i = nodes.size() - 1; i >= 0; i--) {
			nodesReverse.add(nodes.get(i));
		}
		return nodesReverse;
	}

	public Integer getShortestPathLength() {
		if (endNode.getDistance() == Integer.MAX_VALUE) {
			throw new RuntimeException("No Path");
		}
		return endNode.getDistance();
	}
}
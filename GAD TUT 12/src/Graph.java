import java.util.ArrayList;
import java.util.List;



public class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public class Node {
		final int id;
		int distance;
		List<Integer> weightsOfOutgoingNodes;
		Node parent;
		
		public Node (int id) {
			this.id = id;
		}

		public void setWeightsOfOutgoingNodes(List<Integer> weightsOfOutgoingNodes) {
			this.weightsOfOutgoingNodes = weightsOfOutgoingNodes;
		}

		public Integer getID() {
			return id;
		}

		public int getId() {
			return id;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public List<Integer> getWeightsOfOutgoingNodes() {
			return weightsOfOutgoingNodes;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public Graph() {
		// TODO
	}

	public Integer addNode() {
		nodes.add(new Node(nodes.size()));
		return nodes.size();
	}

	public Graph.Node getNode(Integer id) {
		return nodes.get(id);
	}
	

	/**
	 * Fügt eine neue direktionale Kante von Knoten a zu Knoten b
	 * mit Gewicht weight hinzu. Gewicht darf nicht negativ sein.
	 */
	public void addEdge(Graph.Node a, Graph.Node b, Integer weight) {
		if (weight < 0)
			throw new RuntimeException("Weight smaller than 0");
		if (a.getWeightsOfOutgoingNodes() == null) {
			a.setWeightsOfOutgoingNodes(new ArrayList<Integer>(nodes.size()));
			for (int i = 0; i<nodes.size(); i++) {
				a.getWeightsOfOutgoingNodes().add(-1);
			}
			
		}
		try {
			a.getWeightsOfOutgoingNodes().set(b.getID(), weight);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}	
	}
	
}

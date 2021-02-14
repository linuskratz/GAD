import java.util.ArrayList;
import java.util.List;

public class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	
	public class Node {
		boolean isTraversed = false;
		int depth; 
		Node parent;
		List<Node> connectedNodes = new ArrayList<Node>();
		
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			if (!isTraversed) {
				this.parent = parent;
				isTraversed = true;
			}
		}
		public List<Node> getConnectedNodes() {
			return connectedNodes;
		}
		public void setConnectedNodes(List<Node> connectedNodes) {
			this.connectedNodes = connectedNodes;
		}
	}

	/**
	 * Erstellt einen neuen Knoten, und gibt den Index dieses Knotens zurück.
	 * Der erste erstellte Knoten sollte Index 0 haben.
	 * Knoten, die direkt nacheinander erstellt werden, sollten aufsteigende Indices haben.
	 */
	public Integer addNode() {
		nodes.add(new Node());
		return nodes.size();
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Liefert den Knoten zum angegebenen Index zurück
	 */
	public Graph.Node getNode(Integer id) {
		return nodes.get(id);
	}

	/**
	 * Fügt zwischen den beiden angegebenen Knoten eine (ungerichtete) Kante hinzu.
	 */
	public void addEdge(Graph.Node a, Graph.Node b) {
		a.connectedNodes.add(b);
		b.connectedNodes.add(a);
	}
}

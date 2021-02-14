
public class ConnectedComponents {
	private BFS search;

	public ConnectedComponents() {
		search = new BFS();
	}

	/**
	 * Zählt alle Zusammenhangskomponenten im gegebenen Graphen g
	 */
	public int countConnectedComponents(Graph g) {
		if (g.nodes.isEmpty()) {
			return 0;
		}
		int count = 1;
		for (Graph.Node node : g.getNodes()) {
			if (!node.isTraversed) {
				search.sssp(node);
				count++;
			}
		}
		return count;
	}
}
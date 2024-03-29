import java.util.LinkedList;

public class BFS {
	LinkedList<Graph.Node> queue = new LinkedList<Graph.Node>();

	public BFS() {

		// TODO
		// Sie dürfen die Signatur dieser Funktion verändern
		// (z.B. im Parameter im Konstruktor zu übergeben),
		// müssen das dann aber in Graphilia.java entsprechend übernehmen.
	}

	/**
	 * Führt eine Breitensuche vom Startknoten "start" aus, um das SSSP-Problem zu
	 * lösen.
	 */
	public void sssp(Graph.Node start) {
		LinkedList<Graph.Node> newQueue;
		queue.add(start);
		start.setParent(null);
		start.setDepth(0);
		do {
			newQueue = new LinkedList<Graph.Node>();
			for (Graph.Node node : queue) {
				for (Graph.Node child : node.getConnectedNodes()) {
					if (!child.isTraversed) {
						newQueue.add(child);
						child.setParent(node);
						child.setDepth(node.getDepth() + 1);
					}
				}
			}
			queue = newQueue;
		} while (!newQueue.isEmpty());
	}

	/**
	 * Nachdem SSSP ausgeführt wurde, kann mit dieser Funktion die Tiefe des Knotens
	 * n vom Startknoten überprüft werden.
	 */
	public Integer getDepth(Graph.Node n) {
		if (!n.isTraversed)
			throw new RuntimeException();
		return n.getDepth();
	}

	/**
	 * Nachdem SSSP ausgeführt wurde, kann mit dieser Funktion der Vaterknoten des
	 * Knotens n in Richtung Startknoten abgefragt werden.
	 */
	public Graph.Node getParent(Graph.Node n) {
		return n.getParent();
	}
}

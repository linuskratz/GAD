/**
 * Diese Klasse implementiert einen (a,b)-Baum.
 */
public class ABTree {

    /**
     * Diese Variable speichert die untere Schranke des Knotengrades.
     */
    private final int a;

    /**
     * Diese Variable speichert die obere Schranke des Knotengrades.
     */
    private final int b;

    /**
     * Diese Objektvariable speichert die Wurzel des Baumes.
     */
    private ABTreeInnerNode root;

    public ABTree(int a, int b) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    public boolean validAB() {
    	if (recHight(root) == 0) {
    		return false;
    	}
    	
    }
    
    private int recHight(ABTreeInnerNode node) {
    	if (node.getChildren().isEmpty()) {
    		return 1;
    	}
    	for (int i = 1; i<node.getChildren().size(); i++) {
    		if (recHight((ABTreeInnerNode) node.getChildren().get(i)) != recHight((ABTreeInnerNode) node.getChildren().get(0))) {
    			return 0;
    		}
    	}
    	return 1;
    }
    
    /**
     * Diese Methode ermittelt die Höhe des Baumes.
     *
     * @return die ermittelte Höhe
     */
    public int height() {
    	return root.height();
        throw new RuntimeException("Not Implemented");
    }

    /**
     * Diese Methode sucht einen Schlüssel im (a,b)-Baum.
     *
     * @param key der Schlüssel, der gesucht werden soll
     * @return 'true', falls der Schlüssel gefunden wurde, 'false' sonst
     */
    public boolean find(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    /**
     * Diese Methode fügt einen neuen Schlüssel in den (a,b)-Baum ein.
     *
     * @param key der einzufügende Schlüssel
     */
    public void insert(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    /**
     * Diese Methode löscht einen Schlüssel aus dem (a,b)-Baum.
     *
     * @param key der zu löschende Schlüssel
     * @return 'true' falls der Schlüssel gefunden und gelöscht wurde, 'false' sonst
     */
    public boolean remove(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    /**
     * Diese Methode wandelt den Baum in das Graphviz-Format um.
     *
     * @return der Baum im Graphiz-Format
     */
    String dot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph {\n");
        sb.append("\tnode [shape=record];\n");
        if (root != null)
            root.dot(sb, 0);
        sb.append("}");
        return sb.toString();
    }
}

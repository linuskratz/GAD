/**
 * Diese Klasse implementiert einen Knoten in einem AVL-Baum.
 */
public class AVLTreeNode {
	/**
	 * Diese Variable enthält den Schlüssel, den der Knoten speichert.
	 */
	private int key;

	/**
	 * Diese Variable speichert die Balancierung des Knotens - wie in der
	 * Vorlesung erklärt - ab. Ein Wert von -1 bedeutet, dass der linke Teilbaum
	 * um eins tiefer ist als der rechte Teilbaum. Ein Wert von 0 bedeutet, dass
	 * die beiden Teilbäume gleich hoch sind. Ein Wert von 1 bedeutet, dass der
	 * rechte Teilbaum tiefer ist.
	 */
	private int balance = 0;

	private AVLTreeNode left = null;
	private AVLTreeNode right = null;

	public AVLTreeNode(int key) {
		this.key = key;
	}

	/**
	 * Diese Methode ermittelt die Höhe des Teilbaums unter diesem Knoten.
	 *
	 * @return die ermittelte Höhe
	 */
	public int height() {
		if (right== null && left == null)
			return 0;
		if (balance >= 0) {
			return right.height()+1;
		}else {
			return left.height()+1;
		}
	}

	public boolean validAVL() {
		if (right == null && left == null) {
			return true;
		}
		if (right != null && left != null) {
			if (Math.abs(right.height() - left.height())>1) {
				throw new RuntimeException("hight differs too much");
			}
			if (balance == 0 && right.height() != left.height()) {
				throw new RuntimeException("balance = 0, not same hight");
			}
			if (balance == 1 && right.height() -1 != left.height()) {
				throw new RuntimeException("balance = 1, right != left +1 ");
			}
			if (balance == 1 && left.height() -1 != right.height()) {
				throw new RuntimeException("balance = -1, left != right +1 ");
			}
		}
		if (left != null) {
			if (left.key > this.key) {
				throw new RuntimeException("left key bigger than this key");
			}
		}
		if (right != null) {
			if (right.key <= this.key) {
				throw new RuntimeException("right key smaller than or equal this key");
			}
		}
		
		if (left != null && right != null) {
			return left.validAVL() && right.validAVL();
		}else if (left != null) {
			return left.validAVL();
		}else {
			return right.validAVL();
		}	
	}

	/**
	 * Diese Methode sucht einen Schlüssel im Baum.
	 *
	 * @param key der zu suchende Schlüssel
	 * @return 'true', falls der Schlüssel gefunden wurde, 'false' sonst
	 */
	public boolean find(int key) {
		return findNode(key).key == this.key;
	}

	public void insert(int key) {
		AVLTreeNode insertionNode = findNode(key);
		if (key <= this.key) {
			insertionNode.left = new AVLTreeNode(key);
			balance = -1;
		}else {
			insertionNode.right = new AVLTreeNode(key);
			balance = +1;
		}
	}
	
	private AVLTreeNode findNode(int key) {
		if (left != null && right != null) {
			return this;
		}if (this.key <= key) {
			return left.findNode(key);
		}else {
			return right.findNode(key);
		}
	}

	/**
	 * Diese Methode wandelt den Baum in das Graphviz-Format um.
	 *
	 * @param sb
	 *          der StringBuilder für die Ausgabe
	 */
	public void dot(StringBuilder sb) {
		dotNode(sb, 0);
	}

	private int dotNode(StringBuilder sb, int idx) {
		sb.append(String.format("\t%d [label=\"%d, b=%d\"];\n", idx, key, balance));
		int next = idx + 1;
		if (left != null)
			next = left.dotLink(sb, idx, next, "l");
		if (right != null)
			next = right.dotLink(sb, idx, next, "r");
		return next;
	}

	private int dotLink(StringBuilder sb, int idx, int next, String label) {
		sb.append(String.format("\t%d -> %d [label=\"%s\"];\n", idx, next, label));
		return dotNode(sb, next);
	};
}

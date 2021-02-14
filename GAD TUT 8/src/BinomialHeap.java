import java.util.ArrayList;
import java.util.Arrays;

public class BinomialHeap {
	private ArrayList<BinomialTreeNode> trees;

	/**
	 * Dieser Konstruktor baut einen leeren Haufen.
	 */
	public BinomialHeap() {
		trees = new ArrayList<BinomialTreeNode>();
	}

	/**
	 * Diese Methode ermittelt das minimale Element im binomialen Haufen. Wenn es
	 * dieses nicht gibt (bei leerem Haufen), soll eine RuntimeException geworfen
	 * werden.
	 *
	 * @return das minimale Element
	 */
	public int min() {
		if (trees.isEmpty())
			throw new RuntimeException("trees is empty!");

		int min = Integer.MAX_VALUE;
		for (BinomialTreeNode x : trees)
			min = Math.min(min, x.min());

		return min;
	}

	/**
	 * Diese Methode fügt einen Schlüssel in den Haufen ein.
	 *
	 * @param key der einzufügende Schlüssel
	 */
	public void insert(int key) {
		ArrayList<BinomialTreeNode> x = new ArrayList<BinomialTreeNode>();
		x.add(new BinomialTreeNode(key));
		
		if (this.trees.size() == 0) {
			this.trees = x;
		}else {
			merge(this.trees, x);
		}
	}

	private void merge(ArrayList<BinomialTreeNode> a, ArrayList<BinomialTreeNode> b) {
		ArrayList<BinomialTreeNode> result = new ArrayList<BinomialTreeNode>();
		BinomialTreeNode uebertrag = null;
		int k = 0;
		int i = 0;

		while (k < a.size() || i < b.size()) {
			if (i >= b.size()) {
				if (uebertrag != null && uebertrag.rank() == a.get(k).rank()) {
					uebertrag = BinomialTreeNode.merge(a.get(k), uebertrag);
					uebertrag.setRank(uebertrag.rank()+1);
					k++;
				}else if (uebertrag != null) {
					result.add(uebertrag);
					uebertrag = null;
				}else {
					result.add(a.get(k));
					k++;
				}
			}else if (k >= a.size()) {
				if (uebertrag != null && uebertrag.rank() == b.get(i).rank()) {
					uebertrag = BinomialTreeNode.merge(b.get(i), uebertrag);
					uebertrag.setRank(uebertrag.rank()+1);
					i++;
				}else if (uebertrag != null) {
					result.add(uebertrag);
					uebertrag = null;
				} else {
					result.add(b.get(i));
					i++;
				}
			}else {
				BinomialTreeNode aElement = a.get(k);
				BinomialTreeNode bElement = b.get(i);

				if (uebertrag != null) {
					// add ubertrag
					if (uebertrag.rank() < aElement.rank() && uebertrag.rank() < bElement.rank()) {
						result.add(uebertrag);
						uebertrag = null;
					}
					// ubertrag == a.rank
					else if (uebertrag.rank() == aElement.rank() && uebertrag.rank() < bElement.rank()) {
						uebertrag = BinomialTreeNode.merge(aElement, uebertrag);
						uebertrag.setRank(uebertrag.rank()+1);
						k++;
					}
					// ubertrag == b.rank
					else if (uebertrag.rank() == bElement.rank() && uebertrag.rank() < aElement.rank()) {
						uebertrag = BinomialTreeNode.merge(bElement, uebertrag);
						uebertrag.setRank(uebertrag.rank()+1);
						i++;
					}
					// ubertrag == a.rank && b.rank
					else if (uebertrag.rank() == bElement.rank() && uebertrag.rank() == aElement.rank()) {
						result.add(uebertrag);
						uebertrag = BinomialTreeNode.merge(aElement, bElement);
						uebertrag.setRank(uebertrag.rank()+1);
						i++;
						k++;
					}
				} else {
					if (aElement.rank() == bElement.rank()) {
						uebertrag = BinomialTreeNode.merge(aElement, bElement);
						uebertrag.setRank(uebertrag.rank()+1);
						i++;
						k++;
					} else if (aElement.rank() < bElement.rank()) {
						result.add(aElement);
						k++;
					} else if (aElement.rank() > bElement.rank()) {
						result.add(bElement);
						i++;
					}
				}
			}
		}
		if (uebertrag != null) {
			result.add(uebertrag);
		}
		this.trees = result;
	}

	/**
	 * Diese Methode entfernt das minimale Element aus dem binomialen Haufen und
	 * gibt es zurück.
	 *
	 * @return das minimale Element
	 */
	public int deleteMin() {
		if (trees.isEmpty())
			throw new RuntimeException("trees is empty!");

		int min = Integer.MAX_VALUE;
		BinomialTreeNode minNode = null;
		for (BinomialTreeNode x : trees) {
			if (x.min() < min) {
				minNode = x;
				min = x.min();
			}
		}
		trees.remove(minNode);
		BinomialTreeNode[] children = minNode.deleteMin();
		ArrayList<BinomialTreeNode> y = new ArrayList<BinomialTreeNode>(Arrays.asList(children));
		merge(trees,y);
		return min;
	}

	/**
	 * Diese Methode gibt die Binomialbäume aus.
	 */
	public void printTree() {
		for (int i = 0; i < trees.size(); i++) {
			System.out.println("\nTree " + i + ":");
			trees.get(i).print();
		}
	}
}

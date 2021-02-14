import java.util.ArrayList;

/**
 * Diese Klasse repräsentiert einen inneren Knoten des Baumes.
 */
public class ABTreeInnerNode extends ABTreeNode {
    private ArrayList<Integer> keys;
    private ArrayList<ABTreeNode> children;

    public ABTreeInnerNode(ArrayList<Integer> keys, ArrayList<ABTreeNode> children, int a, int b) {
        super(a, b);
        this.keys = keys;
        this.children = children;
    }

    public ABTreeInnerNode(int key, ABTreeNode left, ABTreeNode right, int a, int b) {
        super(a, b);
        keys = new ArrayList<>();
        children = new ArrayList<>();
        keys.add(key);
        children.add(left);
        children.add(right);
    }

    public ABTreeInnerNode(int key, int a, int b) {
        this(key, new ABTreeLeaf(a, b), new ABTreeLeaf(a, b), a, b);
    }
    
    public ArrayList<ABTreeNode> getChildren() {
        return children;
    }
    
    public ArrayList<Integer> getKeys() {
        return keys;
    }

    @Override
    public void insert(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean canSteal() {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean find(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    public boolean remove(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public int height() {
    	if (children.isEmpty())
    		return 1;
        return children.get(0).height()+1;
    }

    @Override
    public Integer min() {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Integer max() {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean validAB(boolean root) {
    	if (!root) {
    		if (getChildren().size() < a || getChildren().size() >b)
    			return false;
    	}
    	
    	boolean validChildren = true;
    	for (int i=0; i<getChildren().size(); i++) {
    		validChildren = validChildren && children.get(i).validAB (false);
    		if (children.get(i).height() != children.get(i+1).height())
    	}
    	return validChildren;
    }
    
    private int recHight() {
    	
    }

    @Override
    public int dot(StringBuilder sb, int from) {
        int mine = from++;
        sb.append(String.format("\tstruct%s [label=\"", mine));
        for (int i = 0; i < 2 * keys.size() + 1; i++) {
            if (i > 0)
                sb.append("|");
            sb.append(String.format("<f%d> ", i));
            if (i % 2 == 1)
                sb.append(keys.get(i / 2));
        }
        sb.append("\"];\n");
        for (int i = 0; i < children.size(); i++) {
            int field = 2 * i;
            sb.append(String.format("\tstruct%d:<f%d> -> struct%d;\n", mine, field, from));
            from = children.get(i).dot(sb, from);
        }
        return from;
    }
}

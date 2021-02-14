/**
 * Diese Klasse repräsentiert ein Blatt des Baumes.
 */
public class ABTreeLeaf extends ABTreeNode {

    public ABTreeLeaf(int a, int b) {
        super(a, b);
    }
    
    @Override
    public void insert(int key) {
        // TODO (???)
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

    @Override
    public boolean remove(int key) {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public int height() {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Integer min() {
        // TODO
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Integer max() {
       return super.
    }

    @Override
    public boolean validAB(boolean root) {
        return true;
    }

    @Override
    public int dot(StringBuilder sb, int from) {
        sb.append(String.format("\tstruct%d [label=leaf, shape=ellipse];\n", from));
        return from + 1;
    }
}

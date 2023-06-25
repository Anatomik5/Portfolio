/**
 * @param root the root of B-Tree
 * @author Alisher Darmenov
 * Binary Tree
 * Each Node has 2 children
 * @since 21.06.2023
 */
public record BTree(Node root) {
    /**
     * @param key the value that should be inserted;
     *            inserts new integer in the tree
     */
    public void insert(int key) {
        Node current = root;
        boolean inserted = false;
        while (!current.isLeaf()) {
            if (key <= current.getKey()) {
                if (current.getChildren()[0] == null) {
                    current.getChildren()[0] = new Node(current, null, key);
                    inserted = true;
                    break;
                } else {
                    current = current.getChildren()[0];
                }
            } else {
                if (current.getChildren()[1] == null) {
                    current.getChildren()[1] = new Node(current, null, key);
                    inserted = true;
                    break;
                } else {
                    current = current.getChildren()[1];
                }
            }
        }
        if (current.isLeaf() && !inserted) {
            current.setChildren(new Node[2]);
            if (key <= current.getKey()) {
                current.getChildren()[0] = new Node(current, null, key);
            } else current.getChildren()[1] = new Node(current, null, key);
        }
    }
}

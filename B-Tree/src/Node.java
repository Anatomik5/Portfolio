/**
 * @since 21.06.2023
 * @author Alisher Darmenov
 * Making node
 */
public class Node {

        private final Node parent; //the parent node
        private Node [] children; //the children of current node
        private int key; // the integer that stored in current node
        public Node(Node parent, Node [] children, int key){
            this.parent = parent;
            this.children = children;
            this.key=key;
        }
        /**
         * @return true if current node is in root Position
         */
        public boolean isRoot(){
            return parent==null;
        }
        /**
         * @return true if current node is in leaf Position, without children
         */
        public boolean isLeaf(){
            return children==null;
        }
        /**
         * sets the new children of current root
         */
        public void setChildren(Node[] children){
            this.children = children;
        }
        /**
         * @param key the new value of key
         * sets the key of current node
         */
        public void setKey(int key){
            this.key = key;
        }
        /**
         * @return parent Node
         */
        public Node getParent(){
            return parent;
        }
        /**
         * @return children Nodes
         */
        public Node[] getChildren(){
            return children;
        }
        /**
         * @return Node's key
         */
        public int getKey(){
            return key;
        }
}

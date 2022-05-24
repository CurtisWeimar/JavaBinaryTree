public class BinaryTreeNode<T extends Comparable<T>> {

    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public T getData() {
        return value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    BinaryTreeNode(T value) {
        this.value = value;
    }

    //TODO: Combine into one set method.
    /*
    This can be combined into a single set method really easily.
     */

    public int set(T value) {
        int bal; //-1 for left +1 for right
        if(value.compareTo(this.value) < 0) {
            bal = -1;
            if(this.left == null) {
                this.left = new BinaryTreeNode<>(value);
            } else {
                left.set(value);
            }
        } else { //If value is greater or equal shove it right
            bal = 1;
            if(this.right == null) {
                this.right = new BinaryTreeNode<>(value);
            } else {
                right.set(value);
            }
        }

        return bal;
    }

    public void set(BinaryTreeNode<T> node) {
        int bal; //-1 for left +1 for right

        //If new node is less than current node
        if(node.value.compareTo(this.value) < 0) {
            bal = -1;
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.set(node);
            }
        } else {
            bal =1;
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.set(node);
            }
        }

    }

    public BinaryTreeNode<T> mostLeft() {
        BinaryTreeNode<T> found = null;

        BinaryTreeNode<T> check = this;
        while(found == null) {
            if(check.left != null) {
                check = check.left;
            } else {
                found = check;
            }
        }

        return found;
    }

    @Override
    public String toString() {
        if(this.left != null && this.right != null) {
            return "Node: " + this.value + "\nLeft: " + this.left.value + "\nRight: " + this.right.value + "\n";
        } else if(this.left == null && this.right == null) {
            return "Node: " + this.value + "\nLeft: null\nRight: null\n";
        } else if(this.left == null) {
            return "Node: " + this.value + "\nLeft: null\nRight: " + this.right.value + "\n";
        } else {
            return "Node: " + this.value + "\nLeft: " + this.left.value + "\nRight: null\n";
        }

    }

}

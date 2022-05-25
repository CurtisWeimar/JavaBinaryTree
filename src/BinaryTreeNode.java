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

    public int height() {

        int _left = 0, _right = 0;
        if(this.left != null) {
            _left = this.left.height();
        }
        if(this.right != null) {
            _right = this.right.height();
        }

        if(_left < _right) {
            return _right + 1;
        } else {
            return _left + 1;
        }
    }

    public int balance() {
        return this.left.height() - this.right.height();
    }

    public BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T value) {
        if(node == null) {
            return null;
        }

        BinaryTreeNode<T> temp = null;
        if(node.value.compareTo(value) == 0) { //If this is the value we want
            return node;
        } else if(node.value.compareTo(value) > 0) { //If node is greater than the value
            temp = remove(node.left, value); //Check left node
            if(temp != null) {
                if (temp.right != null) {
                    this.left = temp.right; //Set new left to removed node's right
                    this.left.mostLeft().left = temp.left; //Place the removed node's left to the left-most of the right
                } else {
                    this.left = temp.left; //If there is no right just stitch up the left(s)
                }

                //Wasn't sure if we wanted to keep returning the node we removed
                //as it would keep running the "remove" logic
                //return temp; //Return the node we were using
                return null;
            }
        } else if(node.value.compareTo(value) < 0) { //If node is smaller than the value
            temp = remove(node.right, value); //Check the right node
            if(temp != null) {
                if(temp.right != null) {
                    this.right = temp.right; //Set the new right node to the removed node's right
                    this.right.mostLeft().left = temp.left; //Set the left node to the left-most node of the new right
                } else {
                    this.right = temp.left; //If there is no right node then just stitch the left in
                }

                //Wasn't sure if we wanted to keep returning the node we removed
                //as it would keep running the "remove" logic
                //return temp; //Return the node we were using
                return null; //Return the removed node
            }
        }

        return temp;
    }

}

public class BinarySearchTree<T extends Comparable<T>> {

    public BinaryTreeNode<T> head;
    private int count = 0;

    public int count() {
        return this.count;
    }

    public BinaryTreeNode<T> getRoot() {
        return head;
    }

    public int balance = 0; // - = extra left; + = extra right

    BinarySearchTree(T value) {
        this.head = new BinaryTreeNode<>(value);
        count++;
    }

    BinarySearchTree() {

    }

    public void add(T value) {

        if (head == null) {
            this.head = new BinaryTreeNode<>(value);
            count++;
            return;
        }

        System.out.println("Value: " + value);

        int bal = head.set(value);
        count++;

//        BinaryTreeNode<T> temp = head;
//        System.out.println("Old Head: " + head.toString());
//        if (bal < 0) {
//            if(head.left.left == null && head.left.right == null) return; //Long-winded "If head.left used to be null"
//            head = head.left;
//            head.right = null;
//            //head.right = temp;
//        } else {
//            if(head.right.left == null && head.right.right == null) return;
//
//            head = head.right;
//            temp.right = null;
//            //head.left = temp;
//        }
//        System.out.println("New Head: " + head.toString());
//        System.out.println(" ");

        balance += bal;
    }

    //This claims it always returns false but it shouldn't
    public boolean contains(T value) {
        if(head == null) return false;

        BinaryTreeNode<T> found = null;

        BinaryTreeNode<T> check = head;
        while(found == null) {
            if(value.compareTo(check.value) == 0) found = check; //If two nodes are equal set found equal to check

            if(value.compareTo(check.value) < 0) { //If value is less than check and check != null check left next
                if(check.left != null) {
                    check = check.left;
                } else break; //If there is no node to the left we know it's not in the list
            } else { //If value is greater than check and check != null check right next
                if(check.right != null) {
                    check = check.right;
                } else break; //If there is no node to the right we know it's not in the list
            }
        }

        return found != null;
    }

    public void remove(T value) {
        if(head == null) return;

        boolean found = false;

        BinaryTreeNode<T> prev = null;
        BinaryTreeNode<T> check = head;

        /*
        This goes until it finds a match. If the match is the head it just sets the head to null.
        If the check value was found to the right of our node we:
            1) Set the right node to the checks right node
            2) Set the left node to the checks left most node
        And vice versa if it is found to the left.
         */
        while(!found) {
            if(value.compareTo(check.value) == 0) {
                count--;
                found = true;
                if(check == head) {
                    head = null;
                    //TODO: Make it so this line chooses head properly
                    head = check.right;
                } else {
                    BinaryTreeNode<T> temp = check;
                    if(check.value.compareTo(prev.value) >= 0) { //Found on the right
                        prev.right = check.right;
                        check.mostLeft().left = check.left;
                    } else {                                     //Found on the left
                        prev.left = check.right;
                        prev.mostLeft().left = check.left;
                    }
                }
            }

            if(check != null) {
                if (value.compareTo(check.value) < 0) {
                    prev = check;
                    check = check.left;
                }else if(value.compareTo(check.value) >= 0) {
                    prev = check;
                    check = check.right;
                }
            }
        }
    }

    public void clear() {
        head = null;
        count = 0;
    }

    public int height() {
        int height = 0;
        if(head != null) height = 1;
        return height;
    }

    public Object[] toArray() {
        Object[] arr = new Object[count];

        inOrder(arr, head);

        return arr;
    }

    public void inOrder(Object[] arr, BinaryTreeNode<T> node) {
        if(node == null) {
            return;
        }

        inOrder(arr, node.left);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = node.value;
                break;
            }
        }
        inOrder(arr, node.right);
    }

    public String inorder() {
        if(head == null) return "";
        String out = inorder(head);
        return out.substring(0, out.length()-2);
    }

    public String inorder(BinaryTreeNode<T> node) {
        if(node == null) { return ""; }
        String out = "";

        out += inorder(node.left);
        out += node.value + ", ";
        out += inorder(node.right);

        return out;
    }

//    public String inorder() {
//        String out = "";
//        if(head == null) return "";
//
//        inOrderString(head, out);
//
//        return out.substring(0, out.length() - 2);
//    }

    public String preorder() {
        String out = "";

        preOrderString(head, out);

        return out.substring(0, out.length() - 2);
    }

    public String postorder() {
        String out = "";

        postOrderString(head, out);

        return out.substring(0, out.length() - 2);
    }

    public void inOrderString(BinaryTreeNode<T> node, String out) {
        if(node == null) {
            return;
        }

        inOrderString(node.left, out);
        out += node.value + ", ";
        inOrderString(node.right, out);
    }

    public void preOrderString(BinaryTreeNode<T> node, String out) {
        if(node == null) {
            return;
        }

        out += node.value + ", ";
        preOrderString(node.left, out);
        preOrderString(node.right, out);
    }

    public void postOrderString(BinaryTreeNode<T> node, String out) {
        if(node == null) {
            return;
        }

        postOrderString(node.left, out);
        postOrderString(node.right, out);
        out += node.value + ", ";
    }

}

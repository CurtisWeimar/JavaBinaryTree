public class AVLTree<T extends Comparable<T>> {
    public BinaryTreeNode<T> head;
    private int count = 0;

    public int count() {
        return this.count;
    }

    public BinaryTreeNode<T> getRoot() {
        return head;
    }

    public int balance = 0; // - = extra left; + = extra right

    AVLTree(T value) {
        this.head = new BinaryTreeNode<>(value);
        count++;
    }

    AVLTree() {

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
        balance += bal;
    }

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

        if(head.value.compareTo(value) == 0) {

        }

        boolean found = false;

        BinaryTreeNode<T> prev = null;
        BinaryTreeNode<T> check = head;

        head.remove(head, value);
        count--;
    }

    public void clear() {
        head = null;
        count = 0;
    }

    public int height() {
        if(head != null) return head.height();
        return 0;
    }

    //TODO: Have array return Breadth-First rather than inorder
    public Object[] toArray() {
        Object[] arr = new Object[count];

        toArray(arr, head);

        return arr;
    }

    public void toArray(Object[] arr, BinaryTreeNode<T> node) {
        if(node == null) {
            return;
        }

        toArray(arr, node.left);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = node.value;
                break;
            }
        }

        toArray(arr, node.right);
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

    public String preorder() {
        if(head == null) return "";
        String out = preorder(head);
        return out.substring(0, out.length() - 2);
    }

    public String preorder(BinaryTreeNode<T> node) {
        if(node == null) return "";
        String out = "";

        out += node.value + ", ";
        out += preorder(node.left);
        out += preorder(node.right);

        return out;
    }

    public String postorder() {
        if(head == null) return "";
        String out = postorder(head);
        return out.substring(0, out.length() - 2);
    }

    public String postorder(BinaryTreeNode<T> node) {
        if(node == null) return "";
        String out = "";

        out += postorder(node.left);
        out += postorder(node.right);
        out += node.value + ", ";

        return out;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        Random r = new Random();

        //Create an in order array
        int size = 50;
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            values.add(i);
        }

        Collections.shuffle(values);

        for(int i = 0; i < size; i++) {
            t.add(values.get(i));
        }



        System.out.println("Balance: " + t.balance + " - = left/+ = right");
        System.out.println("In-Order: " + t.inorder());
        System.out.println("Pre-Order: " + t.preorder());
        System.out.println("Post-Order: " + t.postorder());
    }
}

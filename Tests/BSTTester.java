import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BSTTester<T extends Comparable<T>> {
	
	protected String ArrayToString(Object[] a)
    {
        StringBuilder sb = new StringBuilder();

        if (a.length > 0)
        {
            sb.append(a[0]);
            for (int i = 1; i < a.length; i++)
            {
                sb.append(", ");
                sb.append(a[i]);
            }
        }

        return sb.toString();
    }
	
	@Test
    public void AddOneValueToEmptyTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "10";
        int expectedCount = 1;
        
        bst.add(10);

        String actual = bst.inorder();
        int actualCount = bst.count();

        assertEquals(expectedCount, actualCount);
        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void AddThreeValuesToTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "10, 24, 1337";
        int expectedCount = 3;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        
        String actual = bst.inorder();
        int actualCount = bst.count();

        assertEquals(expectedCount, actualCount);
        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void AddManyValuesToEmptyTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expectedInOrder = "7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500";
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        Object[] actualArray = bst.toArray();
        
        assertEquals(15, bst.count());
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        assertEquals(expectedInOrder, bst.inorder());

        printMyTree(bst);
    }

    @Test
    public void AddManyValuesWithDuplicate()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedInOrder = "7, 8, 9, 10, 11, 12, 13, 24, 24, 90, 100, 110, 1337, 1350, 1400, 1500";
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);
        bst.add(24);

        Object[] actualArray = bst.toArray();
        
        assertEquals(16, bst.count());
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        assertEquals(expectedInOrder, bst.inorder());
        printMyTree(bst);
    }

    @Test
    public void ClearisCorrect()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.clear();
        String actualInorder = bst.inorder();
        
        assertEquals(0, bst.count());
        assertTrue(actualInorder.equals(""));
        printMyTree(bst);
    }

    @Test
    public void ContainsRoot()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertTrue(bst.contains(24));
        printMyTree(bst);
    }

    @Test
    public void ContainsMax()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertTrue(bst.contains(1500));
        printMyTree(bst);
    }

    @Test
    public void ContainsMin()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertTrue(bst.contains(7));
        printMyTree(bst);
    }

    @Test
    public void ContainsMissingValue()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertFalse(bst.contains(42));
        printMyTree(bst);
    }
    
    @Test
    public void CountIsCorrectAfterAdd()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 15;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertEquals(expected, bst.count());
        printMyTree(bst);
    }

    @Test
    public void CountIsCorrectAfterRemove()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 14;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(10);

        assertEquals(expected, bst.count());
        printMyTree(bst);
    }

    @Test
    public void CountIsCorrectAfterAddRemoveAdd()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 13;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(10);
        bst.remove(1337);
        bst.remove(24);

        bst.add(1842);

        assertEquals(expected, bst.count());
        printMyTree(bst);
    }

    @Test
    public void RemoveLeftLeaf()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedInOrder = "24, 1337";
        Integer[] expectedArray = new Integer[] { 24, 1337 };

        bst.add(24);
        bst.add(10);
        bst.add(1337);

        bst.remove(10);

        assertEquals(2, bst.count());
        assertEquals(ArrayToString(expectedArray), ArrayToString(bst.toArray()));
        assertEquals(expectedInOrder, bst.inorder());
        printMyTree(bst);
    }

    @Test
    public void RemoveRightLeaf()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedInOrder = "10, 24";
        Integer[] expectedArray = new Integer[] { 10, 24 };

        bst.add(24);
        bst.add(10);
        bst.add(1337);

        bst.remove(1337);

        assertEquals(2, bst.count());
        assertEquals(ArrayToString(expectedArray), ArrayToString(bst.toArray()));
        assertEquals(expectedInOrder, bst.inorder());
        printMyTree(bst);
    }

    @Test
    public void RemoveRoot()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expected = "10, 1337";
        Integer[] expectedArray = new Integer[] { 10, 1337 };
        int expectedCount = 2;

        bst.add(24);
        bst.add(10);
        bst.add(1337);

        bst.remove(24);
        
        String actual = bst.inorder();
        int actualCount = bst.count();
        Object[] actualArray = bst.toArray();

        assertEquals(expected, bst.inorder());
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void RemoveLeftBranchRoot()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(10);
        
        int actualCount = bst.count();
        Object[] actualArray = bst.toArray();

        assertEquals(expectedCount, actualCount);
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        printMyTree(bst);
    }

    @Test
    public void RemoveRightBranchRoot()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(1337);
        
        int actualCount = bst.count();
        Object[] actualArray = bst.toArray();

        assertEquals(expectedCount, actualCount);
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        printMyTree(bst);
    }

    @Test
    public void RemoveRootFromLargeTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 90, 100, 110, 1337, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(24);

        int actualCount = bst.count();
        Object[] actualArray = bst.toArray();

        assertEquals(expectedCount, actualCount);
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        printMyTree(bst);
    }

    @Test
    public void RemoveDuplicateValueFromLargeTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);
        bst.add(24);

        bst.remove(24);

        int actualCount = bst.count();
        Object[] actualArray = bst.toArray();

        assertEquals(expectedCount, actualCount);
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        printMyTree(bst);
    }

    @Test
    public void OrderedStringInorderIsCorrect()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedInOrder = "7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500";

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertEquals(expectedInOrder, bst.inorder());
        printMyTree(bst);
    }

    @Test
    public void OrderedStringPreorderIsCorrect()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedPreorder = "24, 10, 8, 7, 9, 12, 11, 13, 1337, 100, 90, 110, 1400, 1350, 1500";

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertEquals(expectedPreorder, bst.preorder());
        printMyTree(bst);
    }

    @Test
    public void OrderedStringPostorderIsCorrect()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        String expectedPostorder = "7, 9, 8, 11, 13, 12, 10, 90, 110, 100, 1350, 1500, 1400, 1337, 24";

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        assertEquals(expectedPostorder, bst.postorder());
        printMyTree(bst);
    }

    @Test
    public void HeightOfTheEmptyTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 0;
        int actual = bst.height();

        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void HeightOfTheSimpleTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 1;

        bst.add(24);

        int actual = bst.height();

        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void HeightOfLargeTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 4;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        int actual = bst.height();

        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void HeightOfWorstCaseLeftTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 15;

        bst.add(7);
        bst.add(8);
        bst.add(9);
        bst.add(10);
        bst.add(11);
        bst.add(12);
        bst.add(13);
        bst.add(24);
        bst.add(90);
        bst.add(100);
        bst.add(110);
        bst.add(1337);
        bst.add(1350);
        bst.add(1400);
        bst.add(1500);

        int actual = bst.height();

        assertEquals(expected, actual);
        printMyTree(bst);
    }

    @Test
    public void HeightOfWorstCaseRightTree()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int expected = 15;

        bst.add(1500);
        bst.add(1400);
        bst.add(1350);
        bst.add(1337);
        bst.add(110);
        bst.add(100);
        bst.add(90);
        bst.add(24);
        bst.add(13);
        bst.add(12);
        bst.add(11);
        bst.add(10);
        bst.add(9);
        bst.add(8);
        bst.add(7);

        int actual = bst.height();

        assertEquals(expected, actual);
        printMyTree(bst);
    }
    
    @Test
    public void ToArrayOutputIsCorrect()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);
        
        Object[] actualArray = bst.toArray();

        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
        printMyTree(bst);
    }
	
	@Test
	public void BSTRemoveNodeWithTwoChildrenWhereChildHasDuplicates()
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		bst.add(10);
		bst.add(4);
		bst.add(12);
		bst.add(11);
		bst.add(11);
		bst.add(11);
		bst.add(18);

		Integer[] expectedArray = { 4, 10, 11, 11, 11, 12, 18 };
		assertEquals(ArrayToString(expectedArray), bst.inorder());
		
		bst.remove(11);
		Integer[] inOrderExpectedArray = { 4, 10, 11, 11, 12, 18 };
		//Left, find highest
		Integer[] preOrderExpectedArray = { 10, 4, 12, 11, 11, 18 };
		Integer[] postOrderExpectedArray = { 4, 11, 11, 18, 12, 10 };
		//Right, find lowest
		//Integer[] preOrderExpectedArray = { 10, 4, 18, 11, 11, 12 };
		//Integer[] postOrderExpectedArray = { 4, 11, 11, 18, 12, 10 };
		
		assertEquals(ArrayToString(inOrderExpectedArray), bst.inorder());
		assertEquals(ArrayToString(preOrderExpectedArray), bst.preorder());
		assertEquals(ArrayToString(postOrderExpectedArray), bst.postorder());
		
		
		bst.remove(12);
		Integer[] inOrderExpectedArray2 = { 4, 10, 11, 11, 18 };
		//Left, find highest
		Integer[] preOrderExpectedArray2 = { 10, 4, 11, 11, 18 };
		Integer[] postOrderExpectedArray2 = { 4, 18, 11, 11, 10 };
		//Right, find lowest
		//Integer[] preOrderExpectedArray2 = { 10, 4, 18, 11, 11 };
		//Integer[] postOrderExpectedArray2 = { 4, 11, 11, 18, 10 };
		
		
		assertEquals(ArrayToString(inOrderExpectedArray2), bst.inorder());
		assertEquals(ArrayToString(preOrderExpectedArray2), bst.preorder());
		assertEquals(ArrayToString(postOrderExpectedArray2), bst.postorder());

        printMyTree(bst);
	}

    protected void printMyTree(BinarySearchTree<Integer> tree)
    {
        if (tree.getRoot() == null)
        {
            System.out.println("Tree is empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(tree.getRoot().getData() + " (root)");

        String pointerRight = "└──";
        String pointerLeft = (tree.getRoot().getRight() != null) ? "├──" : "└──";

        TraverseNodes(sb, "", pointerLeft, tree.getRoot().getLeft(), tree.getRoot().getRight() != null);
        TraverseNodes(sb, "", pointerRight, tree.getRoot().getRight(), false);

        System.out.println(sb.toString());
    }

    protected void TraverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeNode<Integer> node, boolean hasRightSibling)
    {
        if (node != null)
        {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling)
            {
                paddingBuilder.append("│  ");
            }
            else
            {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            TraverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            TraverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }

}

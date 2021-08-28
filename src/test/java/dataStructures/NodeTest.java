package dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    Integer[] integerArr1 = {0,1,2,3,4,5,6,7,8,9};

    Node<Integer> integerLList1 = new Node<>(integerArr1);

    @Test
    void createNodeLListFromArray() {
        Node<Integer> ptr = integerLList1;
        for (int i : integerArr1) {
            assertEquals(i, ptr.data.intValue());
            ptr = ptr.next;
        }
    }

    @Test
    void equalsTests() {
        assertEquals(new Node(1), new Node(1));
        assertEquals(integerLList1, integerLList1);
        assertNotEquals(new Node(1), new Node(2));
        assertNotEquals(integerLList1, new Node(new Integer[] {0,1,2,3,4,5,6,7,8,9,10}));
    }

    @Test
    void toStringTest() {
        String expectedLList = "[0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> ]";
        assertEquals(expectedLList, integerLList1.toString());
    }

}

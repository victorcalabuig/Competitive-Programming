package solutions.stacks;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeInOneStaticTest {

    ThreeInOneStatic stacks = new ThreeInOneStatic(10);

    @Test
    void testConstructor() {
        assertEquals(stacks.elements.length, 30);
        assertEquals(stacks.size.length, 3);
        assertEquals(stacks.capacity, 10);
    }

    @Test
    void testOperations() throws
            ThreeInOneStatic.InvalidStackException,
            ThreeInOneStatic.FullStackException
    {
        assertTrue(stacks.isEmpty(0));
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));

        assertThrows(ThreeInOneStatic.InvalidStackException.class,
                () -> stacks.push(-1, 10));
        assertThrows(ThreeInOneStatic.InvalidStackException.class,
                () -> stacks.push(3, 10));

        stacks.push(0, 1);

        assertEquals(stacks.elements[0], 1);
        assertEquals(stacks.size[0], 1);
        assertEquals(stacks.peek(0), 1);

        stacks.push(0, 11);

        assertEquals(stacks.elements[1], 11);
        assertEquals(stacks.size[0], 2);
        assertEquals(stacks.peek(0), 11);
        assertEquals(stacks.pop(0), 11);
        assertEquals(stacks.peek(0), 1);
        assertEquals(stacks.pop(0), 1);
        assertTrue(stacks.isEmpty(0));
        assertEquals(stacks.size[0], 0);
        assertThrows(EmptyStackException.class, () -> stacks.pop(0));

        for (int i = 0; i < 10; i++) stacks.push(0, 1);
        assertThrows(ThreeInOneStatic.FullStackException.class,
                () -> stacks.push(0,1));

        stacks.push(1, 2);

        assertEquals(stacks.elements[10], 2);
        assertEquals(stacks.size[1], 1);
        assertEquals(stacks.peek(1), 2);

        stacks.push(1, 22);

        assertEquals(stacks.elements[11], 22);
        assertEquals(stacks.size[1], 2);
        assertEquals(stacks.peek(1), 22);
        assertEquals(stacks.pop(1), 22);
        assertEquals(stacks.pop(1), 2);
        assertTrue(stacks.isEmpty(1));

    }

    @Test
    void testToString() throws ThreeInOneStatic.InvalidStackException, ThreeInOneStatic.FullStackException {
        String expectedEmptyStacks =
                "Raw array: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
                "Stack 0:\n" +
                    "\tsize=0\n" +
                    "\thead -> \n" +
                "Stack 1:\n" +
                    "\tsize=0\n" +
                    "\thead -> \n" +
                "Stack 2:\n" +
                    "\tsize=0\n" +
                    "\thead -> \n";
        assertEquals(expectedEmptyStacks, stacks.toString());
        for (int i = 0; i < 10; i ++) {
            stacks.push(0, i);
        }
        stacks.push(1, 8);
        stacks.push(1,333);
        stacks.push(2,1024);
        stacks.push(2, 11888);

        String expectedFilledStack =
                "Raw array: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 333, 0, 0, 0, 0, 0, 0, 0, 0, 1024, 11888, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
                        "Stack 0:\n" +
                            "\tsize=10\n" +
                            "\thead -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 -> \n" +
                        "Stack 1:\n" +
                            "\tsize=2\n" +
                            "\thead -> 333 -> 8 -> \n" +
                        "Stack 2:\n" +
                            "\tsize=2\n" +
                            "\thead -> 11888 -> 1024 -> \n";
        assertEquals(expectedFilledStack, stacks.toString());
    }

}

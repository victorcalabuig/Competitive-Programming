package solutions.LinkedLists;

import dataStructures.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDupsTest {

    Integer[][] testInputs = {
            {1},
            {1,2,3},
            {1,1},
            {1,2,3,1,2,3},
            {1,2,1,3,4}
    };

    Integer[][] testOutputs = {
            {1},
            {1,2,3},
            {1},
            {1,2,3},
            {1,2,3,4}
    };

    @Test
    void testSolution() {
        for (int i = 0; i < testInputs.length; i++) {
            Node<Integer> node = new Node<>(testInputs[i]);
            RemoveDups.removeDupsV1(node);
            assertEquals(node, new Node(testOutputs[i]));
        }
        RemoveDups.removeDupsV1(null);
    }

}

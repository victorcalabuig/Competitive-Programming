package solutions.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Three in One: Describe how you could use a single array to implement 3 stacks
 *
 * Static space solution
 */
public class ThreeInOneStatic {

    int[] elements;
    int[] size = new int[3];
    int capacity; // capacity of each stack

    public ThreeInOneStatic(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity * 3];
    }

    /* Push to top of stack. */
    public void push(int stack, int item) throws InvalidStackException, FullStackException {
        if (!validStack(stack)) throw new InvalidStackException();
        if (isFull(stack)) throw new FullStackException();

        elements[getTopIdx(stack) + 1] = item;
        size[stack]++;
    }

    /* Return and remove top item. */
    public int pop(int stack) throws InvalidStackException, EmptyStackException {
        int item = peek(stack);
        size[stack]--;
        return item;
    }

    /* Return without removing top item. */
    public int peek(int stack) throws InvalidStackException, EmptyStackException {
        if (!validStack(stack)) throw new InvalidStackException();
        if (isEmpty(stack)) throw new EmptyStackException();

        return elements[getTopIdx(stack)];
    }

    /* Check if given stack is empty */
    public boolean isEmpty(int stack) {
        return size[stack] == 0;
    }

    /* Return the index of the top element of a given stack */
    private int getTopIdx(int stack) {
        return capacity * stack + size[stack] -1;
    }

    private boolean validStack(int stack) {
        return stack >= 0 && stack <= 2;
    }

    private boolean isFull(int stack) {
        return size[stack] >= capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raw array: ").append(Arrays.toString(elements)).append("\n");
        for (int i = 0; i < 3; i++) {
            sb.append(StackToString(i));
        }
        return sb.toString();
    }

    private String StackToString(int stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack %d:\n", stack));
        sb.append(String.format("\tsize=%d\n", size[stack]));
        sb.append("\thead -> ");
        for (int item : getStackItems(stack)) {
            sb.append(item).append(" -> ");
        }
        return sb.append("\n").toString();
    }

    private List<Integer> getStackItems(int stack) {
        List<Integer> items = new ArrayList<>();
        for (int i = getTopIdx(stack); i >= capacity*stack; i--) {
            items.add(elements[i]);
        }
        return items;
    }

    static class InvalidStackException extends Exception{}
    static class FullStackException extends Exception{}

    /* debugging
    public static void main(String[] args) throws FullStackException, InvalidStackException, EmptyStackException {
        ThreeInOneStatic stacks = new ThreeInOneStatic(10);

        for (int i = 0; i < 10; i ++) {
            stacks.push(0, i);
        }
        stacks.push(1, 8);
        stacks.push(1,333);
        stacks.push(2,1024);
        stacks.push(2, 11888);

        System.out.println(stacks);
    }
    */

}

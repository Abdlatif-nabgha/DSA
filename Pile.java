import java.util.EmptyStackException;

public class Pile<T> {

    private Node top;
    private int size;
    
    // this internal class is for representing each element in the stack
    private class Node {
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Pile() {
        this.top = null;
        this.size = 0;
    }

    // O(1)
    public boolean isEmpty() {
        return top == null;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public void push(T data) {
        Node newNode = new Node(data);
        // Check if the stack is empty
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    // O(1)
    public T pop() {

        // Check if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Grab the top data and return it
        T data = top.data;
        top = top.next;
        size--;
        return data;

    }

    // O(1)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
}

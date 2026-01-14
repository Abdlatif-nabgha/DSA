import java.util.Stack;

public class QueueByStack<T> {

    private Stack<T> stack;

    public QueueByStack() {
        stack = new Stack<>();
    }

    // enqueue: O(n)
    public void enqueue(T element) {
        stack.push(element);
        int n = stack.size();

        // rotate stack so the oldest element stays on top
        for (int i = 0; i < n - 1; i++) {
            T tmp = stack.pop();
            stack.push(tmp);
        }
    }

    // dequeue: O(1)
    public T dequeue() {
        if (stack.size() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return stack.pop();
    }

    // size: O(1)
    public int size() {
        return stack.size();
    }
}

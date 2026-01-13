import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue<T> {
    private Queue<T> queue;

    public StackByQueue() {
        this.queue = new LinkedList<>();
    }

    public int size() {
        return queue.size(); // Complexity: O(1)
    }

    // Complexity: O(n)
    public void push(T element) {
        // 1. Add the new element to the back of the queue
        queue.offer(element);

        // 2. Rotate the queue: Move all elements behind the new one to the back
        // We loop 'size - 1' times because we want to leave the new element at the front.
        int currentSize = queue.size();
        for (int i = 0; i < currentSize - 1; i++) {
            // Remove from front and add to back immediately
            T temp = queue.poll();
            queue.offer(temp);
        }
    }

    // Complexity: O(1)
    public T pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Because we rotated in 'push', the "top" element is already at the front
        return queue.poll();
    }
}
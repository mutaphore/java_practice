import java.util.*;

public class TwoStackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TwoStackQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    private void exchange(Stack<Integer> dst, Stack<Integer> src) {
        while (!src.empty())
            dst.push(src.pop());
    }

    public void enqueue(int val) {
        System.out.println("Enq " + val);
        exchange(stack1, stack2);
        stack1.push(val);
    }

    public int dequeue() {
        int val;

        exchange(stack2, stack1);
        val = stack2.pop();
        System.out.println("Deq " + val);
        return val;
    }

    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        TwoStackQueue tsq = new TwoStackQueue();

        tsq.enqueue(4);
        tsq.enqueue(1);
        tsq.enqueue(2);
        tsq.enqueue(3);
        tsq.dequeue();
        tsq.dequeue();
        tsq.enqueue(5);
        tsq.enqueue(6);

        while (!tsq.isEmpty())
            tsq.dequeue();
    }
}

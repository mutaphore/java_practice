import java.util.*;

public class SortStack {

    // Sort a stack using only another stack as its store data structure
    public static void sort(Stack<Integer> stk) {
        Stack<Integer> store = new Stack<Integer>();
        int top, tmp;

        do {
            top = stk.pop();
            store.push(top);
            if (!stk.empty() && stk.peek() > top) {
                tmp = stk.pop();
                while (!store.empty() && tmp > store.peek())
                    stk.push(store.pop());
                stk.push(tmp);
            }
        } while (!stk.empty());

        while (!store.empty())
            stk.push(store.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();

        stk.push(5);
        stk.push(7);
        stk.push(5);
        stk.push(1);
        stk.push(9);
        stk.push(6);
        stk.push(2);
        stk.push(4);

        sort(stk);
        System.out.println("Sorted stack");
        while (!stk.empty())
            System.out.print(stk.pop() + " ");
        System.out.println();

    }
}

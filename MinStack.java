import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {

        if (min.peek().equals(stack.peek())) {

            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min.peek();

    }

}
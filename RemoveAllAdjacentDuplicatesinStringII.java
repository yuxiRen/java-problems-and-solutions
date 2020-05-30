public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {
        Deque<Ele> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty() || stack.peek().c!=cur) {
                stack.push(new Ele(cur, 1));
            } else if (stack.peek().count == k - 1) {
                while (!stack.isEmpty() && stack.peek().c==cur) {
                    stack.pop();
                }
            } else {
                stack.push(new Ele(cur, stack.peek().count+1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }
}

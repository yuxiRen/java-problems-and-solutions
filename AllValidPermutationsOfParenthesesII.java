/*Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.*/
public class AllValidPermutationsOfParenthesesII {
    private char[] parenthese = new char[]{'(', ')', '<', '>', '{', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        int[] parentheseNum = new int[]{l, l, m, m, n, n};
        int length = 2 * (l + m + n);
        Deque<Character> stack = new ArrayDeque<>();
        validParentheses(parentheseNum, stack, sb, length, res);
        return res;
    }

    private void validParentheses(int[] parentheseNum, Deque<Character> stack, StringBuilder cur, int length, List<String> res) {
        if (cur.length() == length) {
            res.add(cur.toString());
            return;
        }
        for (int i = 0; i < parentheseNum.length; i++) {
            if (i % 2 == 0) {
                if (parentheseNum[i] > 0) {
                    cur.append(parenthese[i]);
                    parentheseNum[i]--;
                    stack.push(parenthese[i]);
                    validParentheses(parentheseNum, stack, cur, length, res);
                    cur.deleteCharAt(cur.length() - 1);
                    parentheseNum[i]++;
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty() && parenthese[i - 1] == stack.peek()) {
                    cur.append(parenthese[i]);
                    parentheseNum[i]--;
                    stack.pop();
                    validParentheses(parentheseNum, stack, cur, length, res);
                    cur.deleteCharAt(cur.length() - 1);
                    parentheseNum[i]++;
                    stack.push(parenthese[i - 1]);
                }
            }
        }
    }
}

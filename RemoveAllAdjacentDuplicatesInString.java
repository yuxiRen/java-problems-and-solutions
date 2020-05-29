public class RemoveAllAdjacentDuplicatesInString {
    //method1:
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char s : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    //method2:
    public String removeDuplicates (String S){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != S.charAt(i)) {
                sb.append(S.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
    }

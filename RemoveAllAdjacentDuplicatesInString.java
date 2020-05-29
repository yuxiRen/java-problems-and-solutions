public class RemoveAllAdjacentDuplicatesInString {
    Deque<Character> stack = new ArrayDeque<>();
        for(char s : S.toCharArray())    StringBuilder sb = new StringBuilder();

{
        if (!stack.isEmpty() && stack.peek() == s) {
            stack.pop();
        } else {
            stack.push(s);
        }
    }
        while (!stack.isEmpty())
{
        sb.append(stack.pop());
    }
        return sb.reverse().toString();
}

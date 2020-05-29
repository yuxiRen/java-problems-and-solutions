import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeduplicationIV {
    //method1. use stack
    public int[] dedup(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < array.length) {
            if (!stack.isEmpty() && stack.peek() == array[i]) {
                i++;
                while (i < array.length && stack.peek() == array[i]) {
                    i++;
                }
                stack.pop();
            } else {
                stack.push(array[i++]);
            }
        }

        int[] res = new int[stack.size()];
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }

    //method2
    public int[] dedup(int[] array) {
        int end = -1;
        int i = 0;
        while (i < array.length) {
            if (end != -1 && array[end] == array[i]) {
                while (i < array.length && array[end] == array[i]) {
                    i++;
                }
                end--;
            } else {
                array[++end] = array[i++];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}

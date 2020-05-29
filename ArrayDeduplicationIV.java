import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeduplicationIV {
    public static void main(String[] args) {
        ArrayDeduplicationIV so = new ArrayDeduplicationIV();
        int [] arr = new int[]{1,1,2,3,3,3,2,1,6};
        so.dedup(arr);
    }

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
        for (int j = res.length - 1; j >=0; j--) {
            res[j] = stack.pop();
        }

        return res;
    }
}

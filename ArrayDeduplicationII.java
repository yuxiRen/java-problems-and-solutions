//sorted array, duplicate ele only retain two
public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int end = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[end - 1] != array[i]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}

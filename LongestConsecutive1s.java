public class LongestConsecutive1s {
    public int longest(int[] array) {
        int prevLength = 0;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                prevLength++;
            } else {
                prevLength = 0;
            }
            res = Math.max(res, prevLength);
        }
        return res;
    }
}

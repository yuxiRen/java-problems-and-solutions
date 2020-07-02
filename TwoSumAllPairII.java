public class TwoSumAllPairII {
    //method1: time: O(N) space: O(1)
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (i > 0 && array[i] == array[i - 1]) {
                i++;
                continue;
            }

            if (array[i] + array[j] == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(array[i++]);
                cur.add(array[j--]);
                res.add(cur);
            } else if (array[i] + array[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}

public class TwoSumAllPairII {
    //method1. two pointers
    // time: O(NlogN) space: O(1)
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

    //Method2. map
    //time: O(N) space: O(N)
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : array) {
            Integer count = countMap.get(a);
            if (a + a == target && count != null && count == 1) {
                List<Integer> cur = new ArrayList<>();
                cur.add(a);
                cur.add(a);
                res.add(cur);
            } else if (countMap.containsKey(target - a) && count == null) {
                List<Integer> cur = new ArrayList<>();
                cur.add(a);
                cur.add(target - a);
                res.add(cur);
            }
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }
        return res;
    }
}

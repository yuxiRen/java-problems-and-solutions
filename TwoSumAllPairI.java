public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int tmp = target - array[i];
            if (map.containsKey(tmp)) {
                for (int idx : map.get(tmp)) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(idx);
                    cur.add(i);
                    res.add(cur);
                }
            }
            List<Integer> idxes = map.get(array[i]);
            if (idxes == null) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
}

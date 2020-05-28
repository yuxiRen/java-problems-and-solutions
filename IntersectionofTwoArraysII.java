public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int n1 : nums1) {
            map1.put(n1, map1.getOrDefault(n1, 0) + 1);
        }
        for (int n2 : nums2) {
            map2.put(n2, map2.getOrDefault(n2, 0) + 1);
        }
        List<Integer> tmp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key1 = entry.getKey();
            if (map2.containsKey(key1)) {
                int times = Math.min(entry.getValue(), map2.get(key1));
                for (int i = 0; i < times; i++) {
                    tmp.add(key1);
                }
            }
        }
        int[] res = new int[tmp.size()];
        for (int j = 0; j < tmp.size(); j++) {
            res[j] = tmp.get(j);
        }
        return res;
    }
}

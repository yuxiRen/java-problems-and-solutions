public class TopKFrequentWords {
    //Time: O(NlogK)
    //Space: O(K)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (s1, s2) -> map.get(s1).equals(map.get(s2)) ?
                        s2.compareTo(s1) : map.get(s1) - map.get(s2)
        );
        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll());
        }

        return res;
    }
}


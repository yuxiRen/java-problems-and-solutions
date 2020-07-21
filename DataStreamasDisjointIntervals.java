public class DataStreamasDisjointIntervals {
    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<Integer, int[]>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer lowerKey = map.lowerKey(val);
        Integer higherKey = map.higherKey(val);
        //case1.在两个intervals的中间
        if (lowerKey != null && higherKey != null && map.get(lowerKey)[1] + 1 == val && map.get(higherKey)[0] - 1 == val) {
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
            //case2.在interval的结尾
        } else if (lowerKey != null && map.get(lowerKey)[1] + 1 >= val) {
            map.get(lowerKey)[1] = Math.max(map.get(lowerKey)[1], val);
            //case3.在interval的开头
        } else if (higherKey != null && map.get(higherKey)[0] - 1 == val) {
            //map.get(higherKey)[0] = Math.min(map.get(higherKey)[0], val);
            //start点改变了，得重新写
            map.put(val, new int[]{val, map.get(higherKey)[1]});
            map.remove(higherKey);
            //case4.独立的interval
        } else {
            map.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> result = new ArrayList<>();
        for (int[] m : map.values()) {
            result.add(m);
        }
        return result.toArray(new int[result.size()][]);
    }
}

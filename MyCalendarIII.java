public class MyCalendarIII {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int count = 0;
        int res = 0;
        for (int v : timeline.values()) {
            count += v;
            res = Math.max(res, count);
        }
        return res;
    }
}

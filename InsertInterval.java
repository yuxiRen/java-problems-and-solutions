public class InsertInterval {
    //method1:
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new int[]{interval[0], 1});
            points.add(new int[]{interval[1], -1});
        }
        points.add(new int[]{newInterval[0], 1});
        points.add(new int[]{newInterval[1], -1});
        Collections.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p2[1] - p1[1];
            }
            return p1[0] - p2[0];
        });
        int count = 0;
        int start = points.get(0)[0];
        for (int i = 0; i < points.size(); i++) {
            count += points.get(i)[1];
            if (count == 0) {
                res.add(new int[]{start, points.get(i)[0]});
                if (i < points.size() - 1) {
                    start = points.get(i + 1)[0];
                }
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    //method2:
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> result = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx++]);
        }
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }
        result.add(new int[]{newStart, newEnd});
        while (idx < intervals.length) {
            result.add(intervals[idx++]);
        }
        return result.toArray(new int[result.size()][]);

    }
}

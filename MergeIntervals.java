public class MergeIntervals {
    //method1
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new int[]{interval[0], 1});
            points.add(new int[]{interval[1], -1});
        }
        Collections.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p2[1] - p1[1];
            }
            return p1[0] - p2[0];
        });
        int start = points.get(0)[0];
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            count += points.get(i)[1];
            if (count == 0) {
                result.add(new int[]{start, points.get(i)[0]});
                if (i < points.size() - 1) {
                    start = points.get(i + 1)[0];
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    //method2
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            //merge
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }

}

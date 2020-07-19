public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new Point(interval[0], 1));
            points.add(new Point(interval[1], -1));
        }
        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.position == p2.position) {
                    return p2.flag - p1.flag;
                }
                return p1.position - p2.position;
            }
        });
        int start = points.get(0).position;
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            count += points.get(i).flag;
            if (count == 0) {
                result.add(new int[]{start, points.get(i).position});
                if (i < points.size() - 1) {
                    start = points.get(i + 1).position;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    class Point {
        int position;
        int flag;
        Point(int p, int f) {
            this.position = p;
            this.flag = f;
        }
    }
}

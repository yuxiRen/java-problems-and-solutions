public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new Point(interval[0], 1));
            points.add(new Point(interval[1], -1));
        }
        points.add(new Point(newInterval[0], 1));
        points.add(new Point(newInterval[1], -1));
        Collections.sort(points, (p1, p2) -> {
            if (p1.position == p2.position) {
                return p2.flag - p1.flag;
            }
            return p1.position - p2.position;
        });
        int count = 0;
        int start = points.get(0).position;
        for (int i = 0; i < points.size(); i++) {
            count += points.get(i).flag;
            if (count == 0) {
                res.add(new int[]{start, points.get(i).position});
                if (i < points.size() - 1) {
                    start = points.get(i + 1).position;
                }
            }
        }
        return res.toArray(new int[res.size()][2]);
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

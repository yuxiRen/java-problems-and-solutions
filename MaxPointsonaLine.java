public class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int max = 0;
            int same = 1;
            int sameX = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length && j != i; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                } else if (points[i][0] == points[j][0]) {
                    sameX++;
                } else {
                    double slope = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    max = Math.max(max, map.get(slope));
                }
            }
            max = Math.max(max, sameX) + same;
            res = Math.max(max, res);
        }
        return res;
    }
}

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(new int[]{interval[0], 1});
            points.add(new int[]{interval[1], -1});
        }
        Collections.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p1[0] - p2[0];
        });
        int count = 0;
        int res = 0;
        for (int[] point : points) {
            count += point[1];
            res = Math.max(res, count);
        }
        return res;
    }
}

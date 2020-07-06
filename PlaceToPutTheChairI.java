public class PlaceToPutTheChairI {
    public List<Integer> putChair(char[][] gym) {
        List<Integer> res = Arrays.asList(-1, -1);
        int r = gym.length;
        int c = gym[0].length;
        int[][] cost = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (gym[i][j] == 'E') {
                    if (!calPath(gym, i, j, cost)) {
                        return res;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (gym[i][j] == 'C') {
                    if (res.get(0) == -1 || cost[i][j] < cost[res.get(0)][res.get(1)]) {
                        res.set(0, i);
                        res.set(1, j);
                    }
                }
            }
        }
        return res;
    }

    private boolean calPath(char[][] gym, int r, int c, int[][] cost) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));
        int curCost = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                List<Point> neighbors = getNei(cur, gym);
                for (Point nei : neighbors) {
                    if (!visited[nei.row][nei.col]) {
                        visited[nei.row][nei.col] = true;
                        cost[nei.row][nei.col] += curCost;
                        queue.offer(nei);
                    }
                }
            }
            curCost++;
        }
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (!visited[i][j] && gym[i][j] == 'E') {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Point> getNei(Point start, char[][] gym) {
        List<Point> neighbors = new ArrayList<>();
        if (start.row > 0 && gym[start.row][start.col] != 'O') {
            neighbors.add(new Point(start.row - 1, start.col));
        }
        if (start.row < gym.length - 1 && gym[start.row][start.col] != 'O') {
            neighbors.add(new Point(start.row + 1, start.col));
        }
        if (start.col > 0 && gym[start.row][start.col] != 'O') {
            neighbors.add(new Point(start.row, start.col - 1));
        }
        if (start.col < gym[0].length - 1 && gym[start.row][start.col] != 'O') {
            neighbors.add(new Point(start.row, start.col + 1));
        }
        return neighbors;
    }

    class Point {
        int row;
        int col;

        public Point(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}

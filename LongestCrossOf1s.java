public class LongestCrossOf1s {
    //O(5 * N^2)
    public int largest(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] leftRight = new int[R][C];
        int[][] rightLeft = new int[R][C];
        int[][] upDown = new int[R][C];
        int[][] downUp = new int[R][C];

        // get length consecutive 1's from left to right for each row
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (c > 0) {
                    leftRight[r][c] = matrix[r][c] == 1 ? leftRight[r][c - 1] + 1 : 0;
                } else {
                    leftRight[r][c] = matrix[r][c];
                }
            }
        }

        // get length consecutive 1's from right to left for each row
        for (int r = 0; r < R; ++r) {
            for (int c = C - 1; c >= 0; --c) {
                if (c < C - 1) {
                    rightLeft[r][c] = matrix[r][c] == 1 ? rightLeft[r][c + 1] + 1 : 0;
                } else {
                    rightLeft[r][c] = matrix[r][c];
                }
            }
        }

        // get length consecutive 1's from top to bottom for each col
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (r > 0) {
                    upDown[r][c] = matrix[r][c] == 1 ? upDown[r - 1][c] + 1 : 0;
                } else {
                    upDown[r][c] = matrix[r][c];
                }
            }
        }

        // get length consecutive 1's from bottom to top for each col
        for (int r = R - 1; r >= 0; --r) {
            for (int c = 0; c < C; ++c) {
                if (r < R - 1) {
                    downUp[r][c] = matrix[r][c] == 1 ? downUp[r + 1][c] + 1 : 0;
                } else {
                    downUp[r][c] = matrix[r][c];
                }
            }
        }

        // calculate the max length of arm
        int ret = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int currArmLength = Math.min(Math.min(leftRight[r][c], rightLeft[r][c]), Math.min(upDown[r][c], downUp[r][c]));
                ret = Math.max(ret, currArmLength);
            }
        }
        return ret;
    }
}

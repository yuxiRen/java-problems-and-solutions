/*Given a matrix that contains only 1s and 0s,
find the largest X shape which contains only 1s,
with the same arm lengths and the four arms joining at the central point.
Return the arm length of the largest X shape.*/
public class LargestXof1s {
    public int largest(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] leftUp = new int[R][C];
        int[][] rightUp = new int[R][C];
        int[][] leftDown = new int[R][C];
        int[][] rightDown = new int[R][C];

        // get length consecutive 1's from leftUp to rightDown for each row
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (c == 0 || r == 0) {
                    leftUp[r][c] = matrix[r][c];
                } else {
                    leftUp[r][c] = matrix[r][c] == 1 ? leftUp[r - 1][c - 1] + 1 : 0;

                }
            }
        }

        // get length consecutive 1's from rightTop to leftBottom for each row
        for (int r = 0; r < R; ++r) {
            for (int c = C - 1; c >= 0; --c) {
                if (c == C - 1 || r == 0) {
                    rightUp[r][c] = matrix[r][c];
                } else {
                    rightUp[r][c] = matrix[r][c] == 1 ? rightUp[r - 1][c + 1] + 1 : 0;
                }
            }
        }

        // get length consecutive 1's from rightBottom to leftTop
        for (int r = R - 1; r >= 0; --r) {
            for (int c = C - 1; c >= 0; --c) {
                if (r == R- 1 || c == C - 1) {
                    rightDown[r][c] = matrix[r][c];
                } else {
                    rightDown[r][c] = matrix[r][c] == 1 ? rightDown[r + 1][c + 1] + 1 : 0;
                }
            }
        }

        // get length consecutive 1's from leftBottom to rightTop for each col
        for (int r = R - 1; r >= 0; --r) {
            for (int c = 0; c < C; ++c) {
                if (r == R - 1 || c == 0) {
                    leftDown[r][c] = matrix[r][c];
                } else {
                    leftDown[r][c] = matrix[r][c] == 1 ? leftDown[r + 1][c - 1] + 1 : 0;
                }
            }
        }

        // calculate the max length of arm
        int ret = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int currArmLength = Math.min(Math.min(leftUp[r][c], rightUp[r][c]), Math.min(rightDown[r][c], leftDown[r][c]));
                ret = Math.max(ret, currArmLength);
            }
        }
        return ret;
    }
}

//method1: convert the 2D array to 1D array and do binary search
//Time: O(log(N*M))

public boolean searchMatrix(int[][] matrix, int target) {  
    int row = matrix.length;
    int col = matrix[0].length;
    int start = 0;
    int end = row * col - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (matrix[mid / col][mid % col] == target) {
            return true;
        } else if (matrix[mid / col][mid % col] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return matrix[start/col][start%col] == target;
}   

//method2: 
//Time: O(logM + logN)
public class SearchAMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int up = 0;
        int down = matrix.length - 1;
        int row = 0;
        // find the largest row# which is <= target
        while (up < down - 1) {
            int midRow = up + (down - up) / 2;
            if (matrix[midRow][0] <= target) {
                up = midRow;
            } else {
                down = midRow - 1;
            }
        }
        if (matrix[down][0] <= target) {
            row = down;
        } else if (matrix[up][0] <= target) {
            row = up;
        } else {
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            int midCol = left + (right - left) / 2;
            if (matrix[row][midCol] == target) {
                return true;
            } else if (matrix[row][midCol] < target) {
                left = midCol + 1;
            } else {
                right = midCol - 1;
            }
        }
        return matrix[row][left] == target;
    }
}
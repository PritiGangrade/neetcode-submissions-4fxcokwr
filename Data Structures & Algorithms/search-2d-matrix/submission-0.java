class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        //check if:
        // target value is either less than smallest value in the matrix or 
        // target value is bigger than the biggest value in the matrix
        if (target < matrix[0][0] || matrix[m-1][n-1] < target) return false;

        //step2: 
        int minRow = 0;
        int maxRow = m-1;
        while (minRow < maxRow) {
            int midRow = minRow + (maxRow - minRow) / 2;
            if (target <= matrix[midRow][n-1]) {
                //then row is 0-midRow
                maxRow = midRow;
            } else {
                // row is midRow+1 - m
                minRow = midRow+1;
            }
        }
            
        int row = minRow;
        int left = 0;
        int right = n-1;
        while (left <= right) {
            //step 3: check if the target value exists in this row.
            int midCol = left+(right-left)/2;
            if (target == matrix[row][midCol]) {
                return true;
            } else if (target < matrix[row][midCol]) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }
        return false;
    }
}

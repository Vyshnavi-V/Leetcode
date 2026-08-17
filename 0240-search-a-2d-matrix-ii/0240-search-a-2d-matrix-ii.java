class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // StairCase Search Approach
        //Time Complexity: O(m + n)$Space Complexity: O(1)

        int m = matrix.length; // Total number of rows
        int n = matrix[0].length; // Total number of columns
        // Edge Case - Empty matrix
        if(matrix==null || m==0 || n==0){
            return false;
        }
        // Start at the Top-Right corner (row 0, last column).
        // Why Top-Right? Elements to the LEFT are SMALLER and Elements BELOW are LARGER.
        int row = 0, col = n-1; 
        while(row<m && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            // Current value is greater than target: Since the current column is sorted top-to-bottom, all elements below matrix[row][col] are even larger.We can safely ELIMINATE the entire current column by moving LEFT.
            else if(matrix[row][col]>target){
                col--;
            }
            // Current value is smaller than target:Since the current row is sorted left-to-right, all elements to the left of matrix[row][col] are even smaller.We can safely ELIMINATE the entire current row by moving DOWN.
            else{
                row++;
            }
            
        }
    return false;

    }
}
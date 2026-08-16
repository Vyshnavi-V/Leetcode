class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary Search On 2D Matrix Pattern
        // Approach: Treat the entire m x n matrix as a single, flattened sorted 1D array of size (m * n) and apply standard Binary Search.
        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns
        // Edge Cae:
        if(matrix==null || m==0 || n==0){
            return false;
        }
        // 1D indices run from 0 to (m * n - 1).
        int low=0;
        int high=(m*n)-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            // 1D to 2D Coordinate Conversion:
            // - row = mid / n : first column is always a multiple of n
            // - col = mid % n : Gives the remainder - how many steps you have moved into the current row
            int row = mid/n;
            int col = mid%n;
            // Convert the 1D Coordinates to 2D Coordinates AND check weather target is found or not
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1; // Target is larger: search right half
            }
            else{
                high=mid-1; // Target is smaller: search left half
            }
        }
    return false; // Target not present in the matrix
    }
}
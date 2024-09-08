class Solution {

    //!  Optimal: TC: O(n+m) SC: O(1)
// ! try how can you element the halfs from each end and you will be able to do it by two ends
//! these two ends are your ends.
 public boolean searchMatrix(int [][] matrix, int key){
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        int row = 0, column = totalColumns - 1;
        while(row < totalRows && column >= 0){
            if(matrix[row][column] == key) return true;
            else if(matrix[row][column] < key) row++;
            else column--; 
        }
        return false;

        }

}
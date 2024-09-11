
// Write an efficient algorithm that searches for a value target 
// in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

public class SearchIn2DSortedArray2 {
 public static void main(String[] args) {
     int [][] matrix = {{1,3,5},
                        {7,9,11},
                        {13,15,17}};
                        System.out.println(searchMatrix(matrix, 13));
 }
 
//!  Optimal: TC: O(n+m) SC: O(1)
// ! try how can you element the halfs from each end and you will be able to do it by two ends
//! these two ends are your ends.
 static boolean searchMatrix(int [][] matrix, int key){
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

 

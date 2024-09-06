class Solution {
    public boolean searchMatrix(int[][] matrix, int key) {
        int low = 0, high = (matrix.length * matrix[0].length) - 1;
    while(low <= high){
        int mid = low + (high - low)/2;
        int row = mid/matrix[0].length;
        int column = mid % matrix[0].length;
        if(matrix[row][column] == key) return true;
        else if(matrix[row][column] < key) low = mid + 1;
        else high = mid - 1; 
    }
    return false;
    }
}
class Solution {
    public int[] findPeakGrid(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        int low = 0, high = totalColumns - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = findMaxElementInColumn(matrix, mid);
            int left = mid -1 >= 0? matrix[row][mid-1] : -1;
            int right = (mid + 1) <= (totalColumns - 1)? matrix[row][mid + 1]:-1;
            if(matrix[row][mid] > left && matrix[row][mid] > right) return new int []{row, mid};
            else if(matrix[row][mid] < left) high = mid - 1;
            else low = mid + 1;
        }
        return new int []{-1,-1};
    }
    private static int findMaxElementInColumn(int[][] matrix, int mid) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][mid] > maxElement){
                maxElement = matrix[i][mid];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
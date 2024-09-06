// Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting
//  of only 0s and 1s. All the rows are sorted in ascending order.
// Your task is to find the index of the row with the maximum number of ones.
// Note: If two rows have the same number of ones, consider the one with a smaller index. 
// If there's no row with at least 1 zero, return -1.

public class Array2DMaxNumberOf1 {
    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{0,0,1},{0,0,0}};
        System.out.println(countMaxOnes(matrix));
        System.out.println(countMaxOnesOptimal(matrix));

    }

    //!Brute: TC: O(n*m) SC: O(1)
    static int countMaxOnes(int [][] matrix){
        int index = -1;
        int max_rows = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            int row_ones = 0;
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 1) row_ones++;
            }
            if(row_ones > max_rows){
                max_rows = row_ones;                    
                index = i;
            }
        }
        return index;
    }
    //!Optimal: SC: O(n log m) SC: O(1) 
    static int countMaxOnesOptimal(int [][] matrix){
        int index = -1;
        int maxCount = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            int rowOnes = matrix[i].length - lowerBound(matrix[i], 1);
            if(rowOnes > maxCount){
                maxCount = rowOnes;
                index = i;
            }
        }
        return index;
    }

    static int lowerBound(int [] array, int key){
        int low = 0;
        int high = array.length - 1;
        int lowerBound = array.length;
    
        while(low <= high){
            int mid = (low + high) / 2;
    
            // Case 1: we found element or we found element > key (a close answer maybe) 
            if(array[mid] >= key){
                lowerBound = mid;
                high = mid - 1;
            }
            // case 2: we were not able to find so reducing searchSpace
            else low = mid + 1;
        }
        return lowerBound;
    }
}

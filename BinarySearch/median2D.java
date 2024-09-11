
import java.util.Arrays;

public class median2D {
    // ! Brute: TC: O(nxm + nxm log nxm) SC: O(nxm)
    static int medianBrute(int [][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int index = 0;
        int [] flattenArray = new int [row * col];
        for(int i=0; i<row; i++){
            for(int j = 0; j<col; j++){
                flattenArray[index++] = matrix[i][j];
            }
        }
        Arrays.sort(flattenArray);
        return flattenArray[(row*col)/2];
    }
    // ! Optimal: TC: (log n * nlogn) SC: O(1)
    // ! the first element that will appear such that the count against its are <= required (n*m/2) is the median
    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}

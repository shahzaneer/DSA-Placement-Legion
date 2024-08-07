public class RotateByNightyDegree {
   public static void main(String[] args) {
    
   }
   
// Brute
// by Obseration and Mathematics using extra space
    static int[][] rotateby90Brute(int [][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }


// optimal
// - First find Tranpose 
// - Reverse Each Row
static void rotateBy90Optimal(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = i; j < matrix[0].length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length - 1 - j];
            matrix[i][matrix.length - 1 - j] = temp;
        }
    }
}
}

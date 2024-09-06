public class SearchIn2DSortedArray {
public static void main(String[] args) {
    int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    System.out.println(findElementBrute(matrix, 5));
    System.out.println(findElementBetterBrute(matrix, 5));
    System.out.println(findElementBetter(matrix, 5));
    System.out.println(findElementOptimal(matrix, 5));

}   

//! Brute: TC: O(n*m) -> Traversing everything.
static boolean findElementBrute(int [][] matrix, int key){
    for(int i = 0; i<matrix.length; i++){
        for(int j=0; j<matrix[i].length;j++){
            if(matrix[i][j] == key) return true;
        }
    }
    return false;

}
// ! BetterBrute: TC: O(n * log m) -> multiple binarySearches
static boolean findElementBetterBrute(int [][] matrix , int key){
    for(int i = 0; i<matrix.length; i++){
        if(bSearch(matrix[i], key)) return true;
    }
    return false;
}

static boolean bSearch(int[] array, int target) {
    int low = 0;
   int high = array.length-1;
   while(low<=high){
    // int mid = (low+high)/2;
    long mid = (low+high)/2;
    int middle = (int) mid;
    if(array[middle] == target) return true;
    else if(array[middle] < target) low = middle + 1;
    else high = middle - 1;
   }
   return false; 
}
//! Better: TC: O(n) + Log m -> applying binary Search only where element maybe found
static boolean findElementBetter(int [][] matrix , int key){
    for(int i=0; i<matrix.length;i++){
        if(matrix[i][0] <= key && matrix[i][matrix[i].length-1] >= key){
            return bSearch(matrix[i], key);
        }
    }
    return false;
}

//! Optimal: TC: O(log (n*m)) -> only a single binary search
// !- hypothetical flattening of 2D array into 1D array and doing maths
static boolean findElementOptimal(int [][] matrix, int key){
    int low = 0, high = (matrix.length * matrix[1].length) - 1;
    while(low <= high){
        int mid = low + (high - low)/2;
        int row = mid/matrix[1].length;
        int column = mid % matrix[1].length;
        if(matrix[row][column] == key) return true;
        else if(matrix[row][column] < key) low = mid + 1;
        else high = mid - 1; 
    }
    return false;
}

}


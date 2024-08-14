
import java.util.ArrayList;
import java.util.List;

class PascalTriangle{
    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(5));
    }

    // TC: O(n) SC: O(1)
    // type 1:  given row and column findout element at that position in Pascal Triangle
    static long findnCr(int n, int r){
        int nCr = 1;
        for(int i=0; i<r;i++){
            nCr = nCr * (n - i);
            nCr = nCr / (i + 1);
        }
        return (long) nCr;
    }
     
    // TC: O(n*n) SC: O(1)
    // Type 2: given row find all the elements in that row
    static List<Long> findRowInPascalTriangle(int rowNos){
        List<Long> row = new ArrayList<>();
        //Dont use zero based indexing here 
        for(int i=1; i<=rowNos; i++){
            row.add(findnCr(rowNos - 1, i - 1));
        }
        return row;
    }
        // TC: O(n) SC: O(1)
    static List<Long> findRowInPascalTriangleOptimized(int rowNos){

        List<Long> row = new ArrayList<>();
        long ans = 1;
        row.add(ans);
        for (int i = 1; i < rowNos; i++) {
            ans = ans * (rowNos - i);
            ans = ans / i;
            row.add(ans);
        }
        return row;
    }
    
    // TC: (n*n*r) SC: O(1)
    // Type 3: given rows Generate entire pascal Triangle
     static List<List<Long>> generatePascalTriangle(int rows){
        List<List<Long>> pascalTriangle = new ArrayList<>();
        for(int i=1; i<=rows; i++){
            List<Long> temp = findRowInPascalTriangleOptimized(i);
            pascalTriangle.add(temp);
        } 
        return pascalTriangle;
      }

      
    }
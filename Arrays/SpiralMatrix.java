
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int [][] array = {
                            {1,2,3},
                            {5,6,7},
                            {9,10,11},
                        };

       System.out.println(spiralPrint(array));                 
    }   

    static List<Integer> spiralPrint(int [][] array){
        List<Integer> spiralMatrix = new ArrayList<>();
        // 4 pointers
        int top = 0, left = 0;
        int right = array.length -1;
        int bottom = array[0].length - 1;

        while (top<=bottom && left <=right) { 
            // now four loops printing each case
            //!CASE1: From left to Right
            for(int i=left; i<=right; i++){
                spiralMatrix.add(array[top][i]);
            }
            top++;

            //!CASE2: From top to bottom
            for(int i = top; i<=bottom; i++){
                spiralMatrix.add(array[i][right]);
            }
            right--;

            //!CASE3: From right to left
            if(top<=bottom){
                for(int i= right; i>=left; i--){
                    spiralMatrix.add(array[bottom][i]);
                }
             bottom--;   
            }
            //!CASE4: From Bottom to top
            if(left<=right){
                for(int i= bottom; i>=top; i--){
                    spiralMatrix.add(array[i][left]);
                }
                left++;
            }
        }
        return spiralMatrix;
    }
}

import java.util.Arrays;

public class moveZeros {
    public static void main(String[] args) {
        int [] array = {0,1,2,0,0,1};
        int [] array2 = {0,1};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public static void moveZeroes(int[] array) {
        int pointer = 0;
        for(int i = 0; i<array.length;i++){
          if(array[i] != 0){
              array[pointer] = array[i];
              pointer++;
          }     
        }
        
        for(int i= array.length-1; i>=pointer;i--){
          array[i] = 0;
        }
      }
}


import java.util.Arrays;

class LeftRotate{
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(rotateLeftOne(array)));

    }

    static int [] rotateLeftOne(int [] array){
        int temp = array[0];
        
        for(int i= 0; i<= array.length - 2; i++){
            array[i] = array[i+1];
        }
        
        array[array.length-1] = temp;

        return array;
    }
}
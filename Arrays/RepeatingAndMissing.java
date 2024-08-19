
import java.util.ArrayList;
import java.util.List;

public class RepeatingAndMissing {
    public static void main(String[] args) {
        int [] array = {1,1,2,3,5};
        System.out.println(repeatingAndMissingBrute(array));
        System.out.println(repeatingAndMissingBetter(array));
        System.out.println(repeatingAndMissingOptimal(array));
        System.out.println(repeatingAndMissingOptimalcheck(array));

    }

    //! Brute : TC: O(n*n) SC: O(1)
    static List<Integer> repeatingAndMissingBrute(int [] array){
        List<Integer> repeatingAndMissing = new ArrayList<>();
        int missingNumber = -1, repeatingNumber = -1;
        for(int i=1; i<=array.length;i++){
            int counter = 0;
            for(int j=0; j<array.length; j++){
                if(array[j] == i){
                    counter++;
                }
            }
            if(counter == 2) repeatingNumber = i;
            if(counter == 0) missingNumber = i;
        }
        repeatingAndMissing.add(repeatingNumber);
        repeatingAndMissing.add(missingNumber);
        return repeatingAndMissing;
    }
    //! Better: TC: O(2n) SC: O(n) (Hashing)
    static List<Integer> repeatingAndMissingBetter(int [] array){
        List<Integer> repeatingAndMissing = new ArrayList<>();
        int [] hashedArray = new int [array.length + 1];
        int missingNumber = - 1, repeatingNumber = -1;
        for(int i=0; i<array.length; i++){
            hashedArray[array[i]]++;
        }

        for(int i = 1; i<hashedArray.length; i++){
            if(hashedArray[i] == 2) repeatingNumber = i;
            if(hashedArray[i] == 0) missingNumber = i;
        }
        repeatingAndMissing.add(repeatingNumber);
        repeatingAndMissing.add(missingNumber);
        return repeatingAndMissing;
    }
    // ! Optimal: TC: O(n) SC: O(1) (mathematics (algebra)) - you will get the answer but you will not know which one is your missing and which one is repeating 
    static List<Integer> repeatingAndMissingOptimal(int [] array){
        List<Integer> repeatingAndMissing = new ArrayList<>();
        int n = array.length;

        long sumN = (n * (n+1)) / 2, sum2N =  (n * (n+1) * (2*n+1)) / 6;    // Sum of firstNNaturalNumbers and sum of their sqauares
        long sum = 0, sum2 = 0;
        for(int i=0; i<array.length; i++){
            sum+= array[i];
            sum2+= (long)array[i] * (long) array[i];
        }
        //  we know now
        long value1 =   sum - sumN;  //( reap-miss)
        long value2 =   sum2 - sum2N; //(reap^2 - miss^2)
        value2 = value2 / value1;  // reap + miss

        // long repeatingNumber = value1 + value2 / 2;  If you missed the fucking brackets you will miss the fucking answer so be very careful
        long repeatingNumber = (value1 + value2) / 2;

        long missingNumber = repeatingNumber - value1;

        repeatingAndMissing.add((int) repeatingNumber);
        repeatingAndMissing.add((int) missingNumber);
        return repeatingAndMissing;
    }


    // ! Maths can be applied in any way totalSum - arraySum or ArraySum - totalSum
    static List<Integer> repeatingAndMissingOptimalcheck(int [] array){
        List<Integer> repeatingAndMissing = new ArrayList<>();
        int n = array.length;

        long sumN = (n * (n+1)) / 2, sum2N =  (n * (n+1) * (2*n+1)) / 6;    // Sum of firstNNaturalNumbers and sum of their sqauares
        long sum = 0, sum2 = 0;
        for(int i=0; i<array.length; i++){
            sum+= array[i];
            sum2+= (long)array[i] * (long) array[i];
        }
        //  we know now
        long value1 =   sumN - sum;  //( reap-miss)
        long value2 =   sum2N - sum2; //(reap^2 - miss^2)
        value2 = value2 / value1;  // reap + miss

        // long repeatingNumber = value1 + value2 / 2;  If you missed the fucking brackets you will miss the fucking answer so be very careful
        long repeatingNumber = (value1 + value2) / 2;

        long missingNumber = repeatingNumber - value1;

        repeatingAndMissing.add((int) repeatingNumber);
        repeatingAndMissing.add((int) missingNumber);
        return repeatingAndMissing;
    }
}

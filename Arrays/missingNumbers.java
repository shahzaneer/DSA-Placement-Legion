
import java.util.HashSet;

public class missingNumbers {

    // Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
    public static void main(String[] args) {
        int [] nums = {3,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberBruteForce(nums));
        System.out.println(missingNumberOpSum(nums));
        System.out.println(missingNumberOpXor(nums));


    }

    // My Way better Solution TC: O(n+n) SC: O(n)
static int missingNumber(int [] array){
    HashSet<Integer> rangeElements = new HashSet<>();

    for(int i=0; i<=array.length;i++){
        rangeElements.add(i);
    }

    for(int i=0; i<array.length;i++){
        rangeElements.remove(array[i]);
    }

   return (int) rangeElements.toArray()[0];
    }

    // BruteForce TC: O(n^2)  SC: O(1)
static int missingNumberBruteForce(int [] array){
    int missingNumber = Integer.MIN_VALUE;
    for(int i= 0; i<= array.length; i++){
        int flag = 0;
        for(int j = 0; j < array.length; j++){
            if(array[j] == i){
                flag = 1;
                break;
            }     
        }
        if(flag == 0){
            missingNumber = i;
            break;
        }
    }
    return missingNumber;
}   

// Optimal using sum:
// TC: O(n) SC: O(1)

static int missingNumberOpSum(int [] array){
    int sum = ((array.length) * (array.length + 1)) / 2; 
    int sumArray = 0;
    for(int i = 0; i<array.length; i++){
        sumArray+=array[i];
    }

    return sum - sumArray;
}
// Optimal using xor
// TC: O(n) SC: O(1)

static int missingNumberOpXor(int [] array){
    int xor1 = 0, xor2 = 0;

    for(int i=0; i< array.length; i++){
        xor1 = xor1 ^ array[i];
        xor2 = xor2 ^ (i+1);
    }
    return xor1 ^ xor2;
}
}

//! : Among the optimal approaches, the XOR approach is slightly better than the summation one because the term (N * (N+1))/2 used in the summation method cannot be stored in an integer if the value of N is big (like 10^5). 
// In that case, we have to use some bigger data types. 
// But we will face no issues like this while using the XOR approach.

    


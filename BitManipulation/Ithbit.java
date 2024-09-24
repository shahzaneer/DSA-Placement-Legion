public class Ithbit {
    public static void main(String[] args) {
        int num = 5; // Binary: 0101
        int i = 1;   // Bit position to manipulate (0-based)

        System.out.println("Original number: " + num); // 5

        // Set the i-th bit
        int set = setBit(num, i);
        System.out.println("After setting bit " + i + ": " + set); // 7 (0111)

        // Unset the i-th bit
        int unset = unSetBit(set, i);
        System.out.println("After unsetting bit " + i + ": " + unset); // 5 (0101)

        // Toggle the i-th bit
        int toggle = ToggleBit(unset, i);
        System.out.println("After toggling bit " + i + ": " + toggle); // 7 (0111)

    //! for one liners we only need to make ready the mask (the second number from which we can perform n binaryOperator mask to gain answer)
    }

    // ! Check if the ith Bit is set or not
    static boolean ithBitisSet(int n, int i){
        return ((n & (1 << i)) != 0);
    }
    //! Setbit the ith if its 1 stays 1   otherwise make it 1
    static int setBit(int num, int i){
        return (num | (1<<i));
    }
    //! UnsetBit the ith if its 0 stays 0 otherwise make it 0
    static int unSetBit(int num, int i){
        return (num & ~(1<<i));
    }

    //! ToggleBit the ith if its 1 make it 0 and vice versa
    static int ToggleBit(int num, int i){
        return (num ^ (1<<i));
    }

    // ! unset the rightmost first bit 
    static int unsetRightmostBit(int num){
        return (num & num - 1);
    }
    // ! set the rightmost first bit 
    static int setRightMostUnsetBit(int num){
        return (num | (num + 1));
    }
    
    // ! Toggle the rightmost first bit 
    static int toggleRightmostBit(int num){
        return (num ^ (num - 1));
    }

    // ! Check if a number is odd or not
    static boolean isOdd(int num){
        return ((num & 1) == 1);
    }

    // ! Divide by two without using / or modulo operator
    static int divisionByTwo(int num){
        return (num >> 1);
    }

    // ! check if the number is a power of two or not.
    static boolean isPowerOfTwo(int num){
        // we know that for being power of two we only have 1 set bit in the binary.
        // that set bit the rightmost bit.
        // if we unset it it will become zero
        // so
        return ((num & num-1) == 0);
    }


    // ! Brute: Count the number of setBits
    static int countSetBits(int num){
        // there is no single liner
        int n = num;
        int counter = 0;
        while(n!=1){
            if(n%2 == 1) counter+=1;
            n = n/2;
        }
        if(n == 1) counter+=1;
        return counter;
    }

    // ! Bit-Operations: Count the number of setBits
    static int countSetBitsBitWise(int num){
        // there is no single liner
        int n = num;
        int counter = 0;
        while(n!=1){
            // if(n%2 == 1) counter+=1; //Odd check can be written as
            // if(n&1 == 1) counter+=1; //more precisely
            counter+= n&1;

            // n = n/2; the division by two is rightshit by 1  as in binary search you do (low+high) >> 1;
            n =  n >> 1;

        }
        if(n == 1) counter+=1;
        return counter;
    }

    // ! Optimal: CountTheSetBits
    static int countSetBitsBitWiseOptimal(int num){
        // there is no single liner
        int n = num;
        int counter = 0;
        while(n!=0){
            // one by one removing the rightmost setBit at the end we will have zero.
            n = n & (n-1);
            counter+=1;
        }
        return counter;
    }
}


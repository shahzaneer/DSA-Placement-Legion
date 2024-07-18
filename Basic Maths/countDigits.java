class countDigits{
    public static void main(String[] args) {
        System.out.println(countDigits(235));
        System.out.println(countDigitsOptimal(235));
    }

    static int countDigits(int num){
        int counter = 0;
        while(num!=0){
                num = num/10;
                counter++;
        }
        return counter;
    }

    static int countDigitsOptimal(int num){
        return (int) Math.log10(num) + 1;     
    }
}

//! BRUTE FORCE APPROACH
// Space Complexity : 
// O(1) as only a constant amount of additional memory for the counter regardless of size of the input number.

// Time Complexity :
// In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
// O(log n)


// ! OPTIMAL APPROACH
// Time Complexity: O(1)as simple arithmetic operations in constant time are computed on integers.

// Space Complexity : O(1)as only a constant amount of additional memory for the count variable regardless of size of the input number.
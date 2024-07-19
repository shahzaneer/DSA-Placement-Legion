
public class Names {
    public static void main(String[] args) {
        // printNames(10, "Shahzaneer Ahmed");
        // printIntegers(15,1);
        // printIntegersReversed(15);
        // System.out.println(sum(5));
        // System.out.println(factorial(5));
        // int [] array = {6,5,4,3,2,1};
        // int [] newArray = arrayReversed(array, 0, 5);
        // for(int i = 0; i < newArray.length; i++){
        //     System.out.print(newArray[i] + " ");
        // }

        // System.out.println(isPalindrome("AMMMMMA  ", 0, 6));
        // System.out.println(isPalindromeIterative(" "));
        System.out.println(fib(5));


    }

    static void printNames(int times, String name){
        if(times == 0) return;
        System.out.println(name);
        printNames(times-1, name);
        printIntegersReversed(15);

    }

    static void printIntegers(int n, int starting){
        if (n < starting) return;
        System.out.println(starting);
        printIntegers(n, ++starting);
    }

    static void printIntegersReversed(int n){
        if(n <= 0) return;
        System.out.println(n);
        printIntegersReversed(n-1);
    }

    static int sum(int n){
     if (n <= 0 ) return 0;
     return n + sum(n-1);

    }

    static int factorial(int n){
        if (n <=1) return 1;
        return n * factorial(n-1);
    }

    static int [] arrayReversed(int [] array, int start, int end) {
        if(start >= end) return array;
        swap(array[start], array[end]);
        return arrayReversed(array, start + 1, end - 1);
    }

    static void swap(int num1, int num2){
        int temp = num2;
        num2 = num1;
        num1 = temp;              
    }

    static boolean isPalindrome(String str, int starting, int ending){
        if(starting >= ending ) return true;
        if(str.charAt(starting) != str.charAt(ending)) return false;  
        return isPalindrome(str, ++starting, --ending);

    }

    static boolean isPalindromeIterative(String s) {
        if (s.length() == 1) return true;
        int starting = 0; 
        int ending = s.length() - 1;
        while(starting >= ending){
         if(s.charAt(starting) != s.charAt(ending)) return false;  
         starting++;
         ending--;
        }
        return true;
     }


     boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        int starting = 0;
        int ending = s.length() - 1;
        while (starting <= ending) {
            char startCh = s.charAt(starting);
            char endCh = s.charAt(ending);
            while(!Character.isLetterOrDigit(startCh)) {
                starting++;
                startCh = s.charAt(starting);
            }
            while(!Character.isLetterOrDigit(endCh)) {
                ending--;
                endCh = s.charAt(ending);
            }     
            if (Character.toLowerCase(startCh) != Character.toLowerCase(endCh)) {
                    return false;
                }
                starting++;
                ending--;
            }
        return true;
    }

    static int fib(int n) {
        if ( n == 1 || n == 0) return n;
        return fib(n-1) + fib(n-2);
    }
}

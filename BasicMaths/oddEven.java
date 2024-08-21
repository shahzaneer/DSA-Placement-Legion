public class oddEven {
    public static void main(String[] args) {
        System.out.println(isOddOrEven(4));
        System.out.println(isOdd(4));
        System.out.println(isEven(4));
    }

    // Without if statement return a num is even or odd
    // way 1;
    // SC: O(p)
    static String isOddOrEven(int num){
        String [] evenOrOdd = {"Even","Odd"};
        return evenOrOdd[num % 2];
    }

    // way 2
    // the 1 will be ANDED with the last significant digit (LSB)
    // example : 7 and 5 
    // 111 & 1 so 1&1 = 1
    // 101 & 1 so 1&1 = 1 

    static boolean isOdd(int num){
        return (num & 1) == 1;
    }

    static boolean isEven(int num){
        return (num & 1) == 0;
    }
}

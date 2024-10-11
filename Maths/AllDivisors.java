import java.util.ArrayList;

public class AllDivisors {
    public static void main(String[] args) {
        System.out.println(allDivisors(702));
        System.out.println(allDivisorsOptimal(702));
    }

    // ! Brute : TC: O(n) SC: O(1)
    static ArrayList<Integer> allDivisors(int number){
        ArrayList<Integer> allDivisors = new ArrayList<>();
        for(int i=1; i<=number; i++){
            if(number % i == 0) allDivisors.add(i);
        }
        return allDivisors;
    }
    // ! Optimal: TC: O(sqrt(n)) SC: O(1)
    static ArrayList<Integer> allDivisorsOptimal(int number){
        ArrayList<Integer> allDivisors = new ArrayList<>();
        for(int i=1; i<= Math.sqrt(number); i++){
            if(number % i == 0) {
                allDivisors.add(i);
                if(number/i != i) allDivisors.add(number/i);
            }
        }
        return allDivisors;
    }
}

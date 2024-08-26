// ! SquareRoot of a Number

public class SquareRoot {
public static void main(String[] args) {
    System.out.println(squareRoot(25));
    System.out.println(squareRootBS(25));

    System.out.println(squareRoot(35));
    System.out.println(squareRootBS(35));
}  
//   always return an answer if not perfectr squareRoot then return the most close one
// for example for 25 we will return 5 for 30 we will return 5.

  //!Brute: TC:O(n) SC: O(1)
  static int squareRoot(int num){
    int squareRoot = 1;
    for(int i=1; i<=num; i++){
        if(i * i <= num){
            squareRoot = i;
        }else{
            break;
        }
    }
    return squareRoot;
  } 

//! Optimal: TC: O(log n) SC: O(1)
// its best when the input is very much high 
static int squareRootBS(int num){
    int low = 1, high = num;
    int squareRoot = 1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(mid * mid <= num){
            squareRoot = mid;
            low = mid + 1;
        } 
        else high = mid - 1;
    }
    return squareRoot;
} 

}
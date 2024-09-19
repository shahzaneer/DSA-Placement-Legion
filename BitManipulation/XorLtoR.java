public class XorLtoR {
    public static void main(String[] args) {
        
    }   
    
    // XOR of Numbers from 1 to Number: given is Number 'n'
    // ! Brute: TC: O(n) SC: O(1)
    static int Xor1ToN(int n){
        int xor = 1;
        for(int i=2; i<=n; i++){
            xor = xor ^ i;
        }
        return xor;
    }
    // ! Optimal: TC : O(1) SC : O(1) -> via observation of Xors
            // n % 4 == 0 → XOR result is n
            // n % 4 == 1 → XOR result is 1
            // n % 4 == 2 → XOR result is n + 1
            // n % 4 == 3 → XOR result is 0
    // ! how? 
// For n = 1 to 4:
// n = 1:
// XOR(1) = 1
// 1 % 4 == 1 → result = 1

// n = 2:
// XOR(1 ^ 2) = 3
// 2 % 4 == 2 → result = 2 + 1 = 3

// n = 3:
// XOR(1 ^ 2 ^ 3) = 0
// 3 % 4 == 3 → result = 0

// n = 4:
// XOR(1 ^ 2 ^ 3 ^ 4) = 4
// 4 % 4 == 0 → result = 4

// For n = 5 to 8:
// n = 5:
// XOR(1 ^ 2 ^ 3 ^ 4 ^ 5) = 1
// 5 % 4 == 1 → result = 1

// n = 6:
// XOR(1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6) = 7
// 6 % 4 == 2 → result = 6 + 1 = 7

// n = 7:
// XOR(1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7) = 0
// 7 % 4 == 3 → result = 0

// n = 8:
// XOR(1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8) = 8
// 8 % 4 == 0 → result = 8

// General Case:
// n % 4 == 0: result = n
// n % 4 == 1: result = 1
// n % 4 == 2: result = n + 1
// n % 4 == 3: result = 0
             
//* Check it by making observations on calculator as a reminder
    static int Xor1ToNOptimal(int n){
        if(n%4 == 0) return n;
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        if(n%4 == 3) return 0;
        return 0;
    }

    // ? L to R?
    //  L = 4 and R = 7 so want -> 4^5^6^7
    // if we find the xor of L-1 ie (1^2^3) then xor it with 1to7Xor that is
    //  (1^2^3) ^ (1^2^3^4^5^6^7)
    //  we will left with (4^5^6^7) which is the required answer

    static int  XorLtoR(int l, int r){
        return Xor1ToN(l-1) ^ Xor1ToNOptimal(r);
    }
}

class Solution {
    public int countPrimes(int number) {
        // Step 1 Pre-Computation
        boolean [] isPrime = new boolean [number+1];
        // Step 2 Initialization:  O(n)
        for(int i = 2; i<number; i++){
            isPrime[i] = true;
        }
        // Step 3: include the first prime and exclude its multiples
        // TC: O(n * (log(log n))
        for(int i=2; i<=Math.sqrt(number); i++){
            if(isPrime[i] == true){
                for(int j = i*i; j<number; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        // Step 4: access the prime number in O(1) and all numbers in O(n)
        int counter = 0;
        for(int i = 2; i<number; i++){
            if(isPrime[i]) counter++;
        }

        return counter;
    }
}
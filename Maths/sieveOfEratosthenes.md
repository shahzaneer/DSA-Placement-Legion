### Sieve of Eratosthenes: Theory and Explanation

The **Sieve of Eratosthenes** is an ancient and highly efficient algorithm for finding all prime numbers up to a given limit \( n \). It was introduced by the Greek mathematician **Eratosthenes** in around 200 BC and remains one of the most popular algorithms for generating prime numbers due to its simplicity and speed.

### Key Concepts:

1. **Prime Numbers:**
   A **prime number** is a number greater than 1 that has no positive divisors other than 1 and itself. Examples include 2, 3, 5, 7, 11, etc.

2. **Composite Numbers:**
   A **composite number** is a number that has divisors other than 1 and itself. For example, 4, 6, 8, 9 are composite numbers.

### How Sieve of Eratosthenes Works:

The Sieve of Eratosthenes eliminates multiples of prime numbers by marking them as composite, leaving only prime numbers unmarked.

### Algorithm Steps:

1. **Initialization:**
   - Start with an array `isPrime[]` of size \( n+1 \) (to include the number \( n \)).
   - Set all values of `isPrime[]` to `true`, except for indices 0 and 1 (which are not prime numbers) — i.e., `isPrime[0] = isPrime[1] = false`.

2. **Elimination of Multiples:**
   - Begin with the first prime number, \( p = 2 \).
   - For each prime \( p \), mark all of its multiples \( 2p, 3p, 4p, \dots \) as composite (i.e., `isPrime[multiple] = false`).
   - Move to the next number in the array that is still marked as `true` (which is the next prime number) and repeat the process.
   - Stop when \( p^2 > n \), since all the remaining numbers will already be marked.

3. **Result:**
   - After the process, the indices that remain `true` in the array `isPrime[]` represent the prime numbers up to \( n \).

### Example:

Find all prime numbers less than or equal to 30:

- Start with an array `isPrime[]` for numbers 0 through 30, with all entries initialized to `true`, except `isPrime[0]` and `isPrime[1]`.
  
- Begin with \( p = 2 \) (the first prime number):
  - Mark all multiples of 2 as composite: \( 4, 6, 8, 10, \dots, 30 \).
  
- Move to the next number, \( p = 3 \):
  - Mark all multiples of 3 as composite: \( 9, 12, 15, 18, \dots, 30 \).
  
- Continue with \( p = 5 \):
  - Mark multiples of 5: \( 25, 30 \).
  
- Skip 4 (already marked as composite) and go to 7, but since \( 7^2 > 30 \), stop.

- The remaining numbers marked as `true` are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 — these are the prime numbers up to 30.

### Time Complexity:

The time complexity of the Sieve of Eratosthenes is \( O(n \log(\log n)) \). This makes it much more efficient than checking each number individually for primality, which would take \( O(n \sqrt{n}) \) time.

### Space Complexity:

The space complexity is \( O(n) \) because of the storage required for the `isPrime[]` array of size \( n \).

### Advantages:

- **Efficiency:** The sieve is highly efficient for generating a large number of primes up to \( n \).
- **Simplicity:** The algorithm is easy to implement and understand.

### Limitations:

- **Memory Usage:** For extremely large \( n \), the space requirement of \( O(n) \) may become a bottleneck.
- **Not Dynamic:** The algorithm finds primes up to a fixed limit \( n \), but cannot be extended to find primes beyond that without re-running the entire algorithm.

### Conclusion:

The Sieve of Eratosthenes is one of the fastest and most widely used algorithms to find all primes up to a given number. Its elegance lies in its ability to quickly eliminate non-prime numbers by marking multiples, reducing the problem's complexity to logarithmic factors.
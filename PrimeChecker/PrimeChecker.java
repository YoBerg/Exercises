/**
 * PrimeChecker by Yohan Berg
 *
 * A java program to check if the given input is a prime number.
 */
public class PrimeChecker {

    /**
     * Testing the checker for all numbers from 1 to 100.
     */
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + " - " + isPrime(i));
        }
    }

    /**
     * Checks if the given number is prime or not.
     * 
     * @param n the number to be checked.
     * @return whether n is prime or not.
     */
    public static boolean isPrime(int n) {
        // Values 1 and below cannot be prime.
        if (n <= 1) return false;

        /**
         * Since all non-prime numbers can be factored 
         * into prime numbers, we just need to check if 
         * the number is a multiple of a prime number.
         */
        // Check 2 and 3
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check every potential prime number 5 and above
        // Since all primes above 3 can be represented with 6n +/- 1,
        // we only need to check these numbers.
        // Also, any factor greater than sqrt(n) can be ignored since
        // another factor will be below sqrt(n).
        // Thus, we only need to check values up to sqrt(n).
        // We must check i - 1 <= n ^ 2 since our formula includes 6n - 1
        // Computing (i - 1) ^ 2 is faster than computing sqrt(n).
        for (int i = 6; (i - 1) * (i - 1) <= n; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
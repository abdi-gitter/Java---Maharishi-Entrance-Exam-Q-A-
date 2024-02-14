/* A prime number is an integer that is divisible only by 1 and itself. 
A porcupine number is a prime number whose last digit is 9
and the next prime number that follows it also ends with the digit 9. 
For example 139 is a porcupine number because:
 a. it is prime
 b. it ends in a 9
 c. The next prime number after it is 149 which also ends in 9. 
 Note that 140, 141, 142, 143, 144, 145, 146, 147 and 148 are not
prime so 149 is the next prime number after 139.
Write a method named findPorcupineNumber which takes an 
integer argument n and returns the first porcupine number that is
greater than n. So findPorcupineNumber(0) would return 139 
(because 139 happens to be the first porcupine number) and so would
findPorcupineNumber(138). But findPorcupineNumber(139) 
would return 409 which is the second porcupine number. */

public class PorcupineNumberFinder {
    public static void main(String[] args) {
        // Test the method
        System.out.println(findPorcupineNumber(139));  // Should return the next porcupine number after 139
    }

    public static int findPorcupineNumber(int n) {
        int currentPrime = findNextPrime(n);
        while (true) {
            int nextPrime = findNextPrime(currentPrime);
            if (isPorcupineNumber(currentPrime, nextPrime)) {
                return currentPrime;
            }
            currentPrime = nextPrime;
        }
    }

    private static boolean isPorcupineNumber(int currentPrime, int nextPrime) {
        return endsWithNine(currentPrime) && endsWithNine(nextPrime);
    }

    private static boolean endsWithNine(int number) {
        return number % 10 == 9;
    }

    private static int findNextPrime(int n) {
        // Start at the next number
        int nextNumber = n + 1;
        // While the number is not prime, increment and check again
        while (!isPrime(nextNumber)) {
            nextNumber++;
        }
        return nextNumber;
    }

    private static boolean isPrime(int num) {
        // Check if num is a multiple of 2 or is less than 2
        if (num < 2 || (num != 2 && num % 2 == 0)) return false;
        // Check the odd numbers from 3 to sqrt(num)
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        // If no divisors were found, the number is prime
        return true;
    }
}

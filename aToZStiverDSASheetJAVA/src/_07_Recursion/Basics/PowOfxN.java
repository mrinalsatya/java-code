package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;
//https://leetcode.com/problems/powx-n/
public class PowOfxN {
    class Solution {

        // Function to calculate x raised to the power n (x^n)
        public double myPow(double x, int n) {

            // Base case: any number raised to power 0 is 1
            if (n == 0)
                return 1;

            // Handle negative powers
            // x^(-n) = (1/x)^n
            if (n < 0) {
                x = 1 / x;

            /*
             Special case:
             Integer.MIN_VALUE = -2^31
             Negating it causes overflow, so we handle it separately
             Example:
             x^(-2^31) = (1/x) * x^(2^31 - 1)
            */
                if (n == Integer.MIN_VALUE)
                    return x * myPow(x, Integer.MAX_VALUE);

                // Convert negative power to positive
                n = -n;
            }

        /*
         Divide the problem:
         Compute x^(n/2) recursively
         This is the core of "Binary Exponentiation"
        */
            double half = myPow(x, n / 2);

        /*
         If n is even:
             x^n = (x^(n/2)) * (x^(n/2))
         If n is odd:
             x^n = (x^(n/2)) * (x^(n/2)) * x
        */
            if (n % 2 == 0)
                return half * half;
            else
                return half * half * x;
        }

    /*
     Example breakdown:
     x = 2, n = 10

     2^10 = (2^5)^2
     2^5  = (2^2)^2 * 2
     2^2  = (2^1)^2
     2^1  = (2^0)^2 * 2
     2^0  = 1
    */
    }

}

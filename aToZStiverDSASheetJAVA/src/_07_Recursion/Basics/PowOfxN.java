package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;

public class PowOfxN {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            x = 1/x;
            if(n == Integer.MIN_VALUE) return x * myPow(x, Integer.MAX_VALUE);
            n = -n;
        }

        double half = myPow(x, n/2);

        return (n%2 == 0) ? half * half : half * half * x;
    }
    // x^n
    // 2^10 <- 32 * 32 = 1024
    // 2^5 <- 4 * 4 * 2 = 32
    // 2^2 <- 2 * 2 = 4
    // 2^1 <- 1*1* 2 = 2
    // 2^0 -> 1
}

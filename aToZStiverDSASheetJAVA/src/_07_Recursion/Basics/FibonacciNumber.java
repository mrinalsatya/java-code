package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;

public class FibonacciNumber {
    public static int printNthFibonacci(int n){
        if(n <= 1)
            return n;

        return printNthFibonacci(n-1) + printNthFibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(printNthFibonacci(10));
    }
}

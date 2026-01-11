package aToZStiverDSASheetJAVA.src._15_DP._1D_DP;
//https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumber {
    // ---------------- Way 1: Top-Down DP (Memoization) ----------------
    // Idea:
    // - Use recursion with caching (dp array) to avoid recomputation.
    // - Each fib(n) is computed once and stored.
    // - This converts exponential recursion into linear time.
    class SolutionMemo {
        int[] dp;

        // Recursive function with memoization
        public int calculate(int n) {
            // Base cases
            if (n <= 1) return n;

            // If already computed, return from cache
            if (dp[n] != -1) {
                return dp[n];
            }

            // Compute, store, and return
            return dp[n] = calculate(n - 1) + calculate(n - 2);
        }

        public int fib(int n) {
            // Initialize dp with -1 to mark uncomputed states
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return calculate(n);
        }
    }

    // ---------------- Way 2: Bottom-Up DP (Tabulation) ----------------
    // Idea:
    // - Build the solution iteratively from 0 to n.
    // - Avoid recursion; directly fill the dp table.
    // - Each state depends only on the previous two.
    class SolutionTab {
        public int fib(int n) {
            if (n <= 1) return n;

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            // Build answers from smaller subproblems
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }

    // ---------------- Way 3: Space Optimized ----------------
    // Idea:
    // - We only need the last two Fibonacci values at any time.
    // - Replace the dp array with two variables.
    // - Best version for interviews after explaining DP.
    class SolutionOptimized {
        public int fib(int n) {
            if (n <= 1) return n;

            int a = 0; // fib(0)
            int b = 1; // fib(1)
            int c = 0;

            // Iteratively compute next Fibonacci numbers
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }

            return c;
        }
    }
}

package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

/*
Greedy Intuition (Interview Explanation)
 - Items can be broken (fractional)
 - To maximize value:
 - always pick the item with highest value/weight ratio
 - If the full item doesn’t fit, take the fraction
This problem always works with greedy.
Complexity (Optimal) - TC: O(n log n) (sorting) | SC: O(n)
 */
public class FractionalKnapSack {
    class Solution {
        public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

            // List to store (value, weight) pairs
            List<List<Integer>> sack = new ArrayList<>();

            // Total maximum value that can be obtained
            double ans = 0.0;

            int n = val.length;

            // Step 1: Store value and weight together
            for (int i = 0; i < n; i++) {
                sack.add(new ArrayList<>(Arrays.asList(val[i], wt[i])));
            }

            /**
             * Step 2: Sort items by decreasing value/weight ratio
             * (Greedy choice: pick the item with maximum value density first)
             */
            Collections.sort(
                    sack,
                    (a, b) -> Double.compare(
                            (double) b.get(0) / b.get(1),
                            (double) a.get(0) / a.get(1)
                    )
            );

            // Step 3: Pick items greedily
            for (List<Integer> item : sack) {

                int value = item.get(0);
                int weight = item.get(1);

                // If entire item can be picked
                if (weight <= capacity) {
                    ans += value;
                    capacity -= weight;
                }
                // Otherwise, pick fractional part
                else {
                    ans += ((double) value / weight) * capacity;
                    capacity = 0;
                }

                // Knapsack is full
                if (capacity == 0) break;
            }

            return ans;
        }
    }

}

package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://leetcode.com/problems/lemonade-change/description/
/*
Key Interview Explanation - Uses a greedy strategy
 - Always prefers giving larger denominations first
 - Keeps smaller bills for future customers
 - Ensures correct change at each step
 Complexity (Optimal) - TC: O(n) | SC: O(1)
 */
public class LemonadeChange {
    class Solution {
        public boolean lemonadeChange(int[] bills) {

            // Count of $5 and $10 bills currently in hand
            int five = 0, ten = 0;

            // Process each customer's bill in order
            for (int i = 0; i < bills.length; i++) {

                // Case 1: Customer pays with $5
                // No change needed
                if (bills[i] == 5) {
                    five++;
                }

                // Case 2: Customer pays with $10
                // Need to give back $5 as change
                else if (bills[i] == 10) {

                    // If we have at least one $5, give change
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        // Cannot give change
                        return false;
                    }
                }

                // Case 3: Customer pays with $20
                // Need to give back $15 as change
                else {

                    // Prefer giving one $10 and one $5 (greedy choice)
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    }

                    // Otherwise, give three $5 bills
                    else if (five >= 3) {
                        five -= 3;
                    }

                    // No valid way to give change
                    else {
                        return false;
                    }
                }
            }

            // Successfully gave change to all customers
            return true;
        }
    }

}

package aToZStiverDSASheetJAVA.src._08_StackAndQueues.Stack;

public class SumOfSubArrayMinimum {
    //TC - O(n) | SC - O(N)
    class Solution {

        /**
         * Finds the index of the Next Smaller Element (NSE) for each element.
         * If no smaller element exists on the right, store n (array length).
         */
        public List<Integer> findNSE(int[] arr) {
            int n = arr.length;
            List<Integer> ans = new ArrayList<>();
            Deque<Integer> st = new ArrayDeque<>();

            // Traverse from right to left
            for (int i = n - 1; i >= 0; i--) {

                // Pop elements that are >= current element
                // because they cannot be the NSE
                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element on right
                int ind = st.isEmpty() ? n : st.peek();
                ans.add(ind);

                // Push current index
                st.push(i);
            }

            // Reverse because we filled answers from right to left
            Collections.reverse(ans);
            return ans;
        }

        /**
         * Finds the index of the Previous Smaller Element (PSE) for each element.
         * If no smaller element exists on the left, store -1.
         */
        public List<Integer> findPSE(int[] arr) {
            int n = arr.length;
            List<Integer> ans = new ArrayList<>();
            Deque<Integer> st = new ArrayDeque<>();

            // Traverse from left to right
            for (int i = 0; i < n; i++) {

                // Pop elements that are strictly greater than current element
                // to maintain monotonic increasing stack
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element on left
                int ind = st.isEmpty() ? -1 : st.peek();
                ans.add(ind);

                // Push current index
                st.push(i);
            }

            return ans;
        }

        /**
         * Calculates the sum of minimums of all subarrays.
         */
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;

            // Get Next Smaller and Previous Smaller indices
            List<Integer> nse = findNSE(arr);
            List<Integer> pse = findPSE(arr);

            int mod = 1_000_000_007;
            long total = 0;

            // Each element contributes as the minimum in:
            // (distance to left smaller) * (distance to right smaller) subarrays
            for (int i = 0; i < n; i++) {
                long left = i - pse.get(i);
                long right = nse.get(i) - i;
                long contribution = left * right * arr[i];

                total = (total + contribution) % mod;
            }

            return (int) total;
        }
    }

}

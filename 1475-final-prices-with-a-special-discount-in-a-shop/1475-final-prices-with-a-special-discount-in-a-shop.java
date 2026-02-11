import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove prices that can't be a discount
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Apply discount if available
            if (stack.isEmpty()) {
                answer[i] = prices[i];
            } else {
                answer[i] = prices[i] - stack.peek();
            }

            // Push current price onto stack
            stack.push(prices[i]);
        }

        return answer;
    }
}

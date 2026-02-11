class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < len && temperatures[i] >= temperatures[next]) {
                if (result[next] == 0)
                    break;// No warmer day ahead
                next += result[next]; // Skip ahead using jump table
            }
            if (next < len && temperatures[i] < temperatures[next]) {
                result[i] = next - i; // Calculate days to the next warmer day
            }
        }
        return result;
    }
}
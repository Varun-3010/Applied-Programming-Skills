class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // Keep only top k elements in heap
        for (int key : freq.keySet()) {
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build result array
        int[] result = new int[k];
        int i = 0;

        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }

        return result;
    }
}
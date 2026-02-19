class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] vals = new int[20001];
        int maxFreq = 0; // At most N, n <= 100000
        // Keep track of frequency by shifting range
        for (int number : nums) {
            int val = 10000 - number;
            vals[val]++;
            maxFreq = Math.max(vals[val], maxFreq);
        }

        ArrayList<Integer>[] freqToValue = new ArrayList[maxFreq + 1];
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == 0) continue; // 0 occurences
            int val = 10000 - i;
            if (freqToValue[vals[i]] == null) freqToValue[vals[i]] = new ArrayList<Integer>();
            freqToValue[vals[i]].add(val);
        }

        Queue<Integer> result = new LinkedList<>();
        for (int i = 0; i < freqToValue.length; i++) {
            if (freqToValue[i] == null) continue;
            for (int num : freqToValue[i]) {
                result.offer(num);
                if (result.size() > k) result.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int val : result) res[idx++] = val;
        return res;
    }
}
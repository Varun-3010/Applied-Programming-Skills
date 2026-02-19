class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // List<List<Integer>> result = new ArrayList<>(); 

        // // if(
        // //     nums1.length < 2 || nums2.length < 2 || 
        // //     nums1.length > (int) Math.pow(10, 5) || nums2.length > (int) Math.pow(10, 5) ||
        // //     nums1.length > (int) Math.pow(10, 9) || nums2.length > (int) Math.pow(10, 9) ||
        // //     k < 1 || k > (int) Math.pow(10, 4) || 
        // //     k > nums1.length * nums2.length
        // // ) return result;

        // PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
        //     (a, b) -> {
        //         int sumA = a.get(0) + a.get(1);
        //         int sumB = b.get(0) + b.get(1);
        //         return Integer.compare(sumA, sumB);
        //     }
        // );

        // for (int n : nums1) {
        //     for (int n2 : nums2) {
        //         queue.offer(Arrays.asList(n, n2));
        //     }    
        // }

        // for (int i = 0; i< k; i++) {
        //     result.add(queue.poll());
        // } 

        // return result;  

        List<List<Integer>> result = new ArrayList<>(k);

        if (nums1.length == 0 || nums2.length == 0 || k == 0) 
            return result;

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Tracks next index in nums2 for each nums1[i]
        int pointer[] = new int[n1];

        while(k > 0){
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            // find the pair with smallest sum
            for(int i = 0; i < n1; i++){
                if(pointer[i] == n2) continue;    // no more pairs left for this i

                int sum = nums1[i] + nums2[pointer[i]];

                if(sum < minSum){
                    minSum = sum;
                    index = i;
                }

                // important optimization: break early
                if(pointer[i] == 0) break;
            }

            // if no pair found, break
            if(index == -1) break;

            // add the chosen pair
            result.add(List.of(nums1[index], nums2[pointer[index]]));

            // move pointer forward
            pointer[index]++;

            k--;
        }
        return result;
    }
}
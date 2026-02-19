class Solution {
    public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> minheap = new PriorityQueue<>();
            for(int i=0; i<nums.length; i++){
                if(minheap.size()<k || nums[i] > minheap.peek()){
                    minheap.add(nums[i]);
                }
                if(minheap.size()>k){
                    minheap.poll();
                }
            }
    return minheap.poll();}
}
    
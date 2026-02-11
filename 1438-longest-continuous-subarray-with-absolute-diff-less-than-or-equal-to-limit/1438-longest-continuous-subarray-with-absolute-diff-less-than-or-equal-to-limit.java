class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // LinkedList<Integer> inc = new LinkedList<>(); // monotonic inc stack
        // LinkedList<Integer> dec = new LinkedList<>(); // monotonic dec stack

        int i=0;
        int j=0;
        int n = nums.length;
        int ans = 0;

        int[] inc = new int[n];
        int[] dec = new int[n];

        int si = 0;
        int ei = 0;

        int sd = 0;
        int ed = 0;

        while(j < n){
            while(ei > si && nums[j] < inc[ei-1]){
                ei--;
            }
            inc[ei++] = nums[j];

            while(ed > sd && nums[j] > dec[ed-1]){
                ed--;
            }
            dec[ed++] = nums[j];

            while(dec[sd] - inc[si] > limit){
                if(nums[i] == dec[sd]){
                    sd++;
                }
                if(nums[i] == inc[si]){
                    si++;
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }

        return ans;
    }
}
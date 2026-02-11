class Solution { 
    public int[] sortedSquares(int[] nums) { 
        int[] result = new int[nums.length]; 
        // Step 1: Square all elements 
        for (int i = 0; i < nums.length; i++) { 
            nums[i] = nums[i] * nums[i]; 
        } 
        // Step 2: Two pointers 
        int head = 0; 
        int tail = nums.length - 1; 
        // Step 3: Place elements from right to left 
        for (int pos = nums.length - 1; pos >= 0; pos--) { 
            if (nums[head] > nums[tail]) { 
                result[pos] = nums[head]; 
                head++;   // move head pointer 
            } else { 
                result[pos] = nums[tail]; 
                tail--;   // move tail pointer 
            } 
        } 
        return result; 
    }
}
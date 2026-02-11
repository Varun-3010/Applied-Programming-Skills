 
class Solution { 
    public void sortColors(int[] nums) { 
        int start = 0, mid = 0, end = nums.length - 1; 
        while (mid <= end) { 
            switch (nums[mid]) { 
                case 0: 
                    swap(nums, start++, mid++); 
                    break;
                 case 1: 
                    mid++; 
                    break; 
                case 2: 
                    swap(nums, mid, end--); 
                    break; 
            } 
        } 
    } 
    private void swap(int[] nums, int i, int j) { 
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
}
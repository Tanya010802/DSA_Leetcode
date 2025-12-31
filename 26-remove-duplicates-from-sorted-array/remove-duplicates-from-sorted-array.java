class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int no_of_unique = 1;
        while(right<nums.length)
        {
            if(nums[left]!=nums[right])
            {
                nums[left+1]=nums[right];
                no_of_unique++;
                left++;
            }
           right++;
            }
        
       return no_of_unique; 
    }
    
}
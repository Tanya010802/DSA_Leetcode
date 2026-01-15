class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int OneCounter = 0;
        int MaxConsOne =0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
              OneCounter++;
            }
            else
            {OneCounter=0;}
            MaxConsOne = Math.max(OneCounter,MaxConsOne);
        }
        
       
        return MaxConsOne;
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0]+nums[1]+nums[2];
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int l= i+1;
            int r=nums.length-1;
            while(l<r)
            {
                sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(target-closest))
                {
                    closest = sum;
                }
                if(target-nums[i]>nums[l]+nums[r])
                {
                    l++;
                }
                else{r--;}
            }

        }
       return closest; 
        
    }
}
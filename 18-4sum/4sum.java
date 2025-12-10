class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>fourSum = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-3;i++)
        {
            if(i>0&& nums[i-1]==nums[i])
            {
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++)
            {
if(j>i+1&& nums[j-1]==nums[j])
{
    continue;
}
int l = j+1;
int r =nums.length-1;
while(l<r)
{
    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
    if(sum==target){
        fourSum.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l],nums[r])));
        l++;
        r--;
         while(l<r && nums[l]==nums[l-1]) l++;
                        while(r>l && nums[r]==nums[r+1]) r--;
                    
    }
     else if (sum>target)
                    r--;
                    else
                    l++;
} 
            }
        }
        return fourSum;
        
    }
}
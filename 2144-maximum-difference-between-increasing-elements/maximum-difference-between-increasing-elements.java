class Solution {
    public int maximumDifference(int[] nums) {
        int max = -1 ;
        int n = nums.length ;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    int temp = nums[j] - nums[i] ;
                    max = Math.max(max, temp);
                }
            }
        }
        return max ;
    }
}
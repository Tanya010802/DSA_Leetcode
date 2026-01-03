class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int highestsquarenum = n-1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right)
        {
            int leftsquare = nums[left]*nums[left];
            int rightsquare = nums[right]*nums[right];
            if(leftsquare>rightsquare)
            {
                arr[highestsquarenum--] = leftsquare;
                left++;
            }
            else{
                 arr[highestsquarenum--] = rightsquare;
                right--;
            }
        }
        return arr;
    }
}
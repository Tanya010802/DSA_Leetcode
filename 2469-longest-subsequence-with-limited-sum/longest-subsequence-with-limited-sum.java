class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefixSum = new int[n];
         prefixSum[0] = nums[0];
         for(int i=1;i<n;i++)
         {
             prefixSum[i] = prefixSum[i - 1] + nums[i];
         }
          int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(prefixSum, queries[i]);
        }

        return result;

        
    }
     private int binarySearch(int[] prefixSum, int target) {
        int left = 0, right = prefixSum.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefixSum[mid] <= target) {
                answer = mid + 1; // mid index means mid+1 elements
                left = mid + 1;   // try to take more
            } else {
                right = mid - 1;  // try fewer elements
            }
        }

        return answer;
    }

}
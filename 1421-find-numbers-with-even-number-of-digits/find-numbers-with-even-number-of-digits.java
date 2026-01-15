class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int num : nums){
            int numlength = String.valueOf(num).length();
            if(numlength % 2 == 0) evenCount++;  
        }
       return evenCount; 
    }
}
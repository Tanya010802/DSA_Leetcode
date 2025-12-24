class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int applCnt =0;
        for(int n:apple){
            applCnt+=n;
        }
        Arrays.sort(capacity);
        int i=capacity.length-1,ans=0;
        while(applCnt>0){
            applCnt-=capacity[i--];ans++;
        }

        return ans;
        
    }
}
class Solution {
    public int minDeletionSize(String[] strs) {
        int rowL = strs.length;
        int colL = strs[0].length();
        int ans = 0;

        for(int i=0;i<colL;i++){
            for(int j=1;j<rowL;j++){
                if(strs[j-1].charAt(i) > strs[j].charAt(i)){
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
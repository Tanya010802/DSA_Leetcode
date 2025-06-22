class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int len = s.length()/k;
        if(s.length()%k!=0) len += 1;

        String[] res = new String[len];

        int j=0;
        for(int i=0;i<s.length();i=i+k){
            res[j] = s.substring(i, Math.min(i+k, s.length()));
            j++;   
        }

        if(res[len-1].length()!=k){
            StringBuilder sb = new StringBuilder();
            sb.append(res[len-1]);
            while(sb.length()!=k) sb.append(fill);
            res[len-1] = sb.toString();
        }

        return res;
    }
}
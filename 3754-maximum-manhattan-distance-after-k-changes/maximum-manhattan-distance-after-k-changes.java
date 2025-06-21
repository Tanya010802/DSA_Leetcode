class Solution {
    public int maxDistance(String s, int k) {
        
        int maxdis=0;
        int west=0;
        int east=0;
        int north = 0;
        int south = 0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i); 
            if(c == 'E') east++;
            else if( c == 'W') west++;
            else if( c == 'N') north++;
            else if( c == 'S') south++;

            int tolstep=i+1;
            int dis=Math.abs(east - west) + Math.abs(north - south);
            int wassteps=tolstep-dis;
            int extra=0;
            if(wassteps!=0){
            extra=Math.min(2*k,wassteps);
            }
            int finaldis =dis+extra;

            maxdis= Math.max(maxdis,finaldis);


        }
        return maxdis;
    }
}
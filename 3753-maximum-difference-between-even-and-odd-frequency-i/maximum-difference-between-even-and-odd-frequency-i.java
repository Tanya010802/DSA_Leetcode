class Solution {
    private ArrayList<Integer> even = new ArrayList<>();
    private ArrayList<Integer> odd = new ArrayList<>();
    public int maxDifference(String s) {
        String newString = "";
        String prevString = s;
        while(prevString.length()!=0){
            newString = prevString.replace(String.valueOf(prevString.charAt(0)),"");
            int freq = prevString.length()-newString.length();
            if(freq%2==0) even.add(freq);
            else odd.add(freq);
            prevString = newString;
            newString = "";
        }
        return Collections.max(odd)-Collections.min(even);
    }
}
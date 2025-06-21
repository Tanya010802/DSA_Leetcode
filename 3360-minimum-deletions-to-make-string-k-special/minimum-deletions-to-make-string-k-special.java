class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = word.toCharArray();
        for (char c : chars){
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }
        ArrayList<Integer> freqList = new ArrayList<>(charMap.values());
        Collections.sort(freqList);

        int minDeletions = Integer.MAX_VALUE;
        int n = freqList.size();

        for(int i=0;i<n;i++){
            int base = freqList.get(i);
            int totalDeletions = 0;
            for(int j=0;j<n;j++){
                if(freqList.get(j) < base){
                    totalDeletions += freqList.get(j);
                }else if(freqList.get(j) > base+k){
                    totalDeletions += freqList.get(j) - (base+k);
                }
            }
            minDeletions = Math.min(minDeletions, totalDeletions);
        }
        return minDeletions;
    }
}
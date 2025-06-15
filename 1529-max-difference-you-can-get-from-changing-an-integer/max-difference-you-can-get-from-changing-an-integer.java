class Solution {
    public int maxDiff(int num) {
        String stringRepresentation = String.valueOf(num);
        var results = new HashSet<Integer>();
        
        for (char x = '0'; x <= '9'; x++) {
            for (char y = '0'; y <= '9'; y++) {
                String replaced = stringRepresentation.replace(x, y);
                int value = Integer.parseInt(replaced);
                if (value != 0 && String.valueOf(value).length() == stringRepresentation.length()) {
                    results.add(value);
                }
            }
        }
        
        return results.stream().max(Integer::compare).orElse(0) - 
               results.stream().min(Integer::compare).orElse(0);
    }
}
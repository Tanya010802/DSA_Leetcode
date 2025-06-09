class Solution {
    public int findKthNumber(int n, int k) {
        return (int) dfs(n, k, 1);
    }
    
    private long dfs(long n, long k, long prefix) {
        if (k == 1) return prefix;
        
        long gap = getGap(prefix, prefix + 1, n);
        if (k <= gap) {
            // Go down one level in the tree (prefix * 10)
            return dfs(n, k - 1, prefix * 10);
        } else {
            // Move to next prefix
            return dfs(n, k - gap, prefix + 1);
        }
    }

    private long getGap(long a, long b, long n) {
        long gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        // Calculate base profit (no changes to strategy)
        long maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit += prices[i] * strategy[i];
        }
        
        // Define sliding window boundaries
        int windowStart = 0;
        int windowMid = k / 2;  // Split point: before this = hold, after this = buy
        int windowEnd = k;
        
        // Calculate profit for first window (indices 0 to k-1)
        long currentProfit = maxProfit;
        
        // Remove profit from first half (convert to holds)
        for(int i = windowStart; i < windowMid; i++) {
            currentProfit -= prices[i] * strategy[i];
        }
        
        // Remove profit from second half and convert to buys
        for(int j = windowMid; j < windowEnd; j++) {
            currentProfit -= prices[j] * strategy[j];  // Remove original action
            currentProfit += prices[j];                 // Add as buy (strategy = 1)
        }
        
        maxProfit = Math.max(maxProfit, currentProfit);
        
        // Slide the window across remaining prices
        while(windowEnd < prices.length) {
            // Remove leftmost element from window (restore its original profit)
            currentProfit += strategy[windowStart] * prices[windowStart];
            
            // Shift middle element (restore original, was treated as buy)
            currentProfit -= prices[windowMid];
            
            // Add rightmost element to window (convert to buy)
            currentProfit -= prices[windowEnd] * strategy[windowEnd];  // Remove original
            currentProfit += prices[windowEnd];                         // Add as buy
            
            maxProfit = Math.max(maxProfit, currentProfit);
            
            // Slide window forward
            windowStart++;
            windowMid++;
            windowEnd++;
        }
        
        return maxProfit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        int[][] dp = new int[n][2];
        
        // initialize dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return f(0, 1, prices, n, dp);
    }
    
    private int f(int i, int buy, int[] prices, int n, int[][] dp) {
        if (i >= n) return 0;  // base case: no more days
        
        if (dp[i][buy] != -1) return dp[i][buy];
        
        int profit = 0;
        if (buy == 1) {
            // choice: buy or skip
            profit = Math.max(-prices[i] + f(i+1, 0, prices, n, dp), 
                               f(i+1, 1, prices, n, dp));
        } else {
            // choice: sell or skip
            profit = Math.max(prices[i] + f(i+2, 1, prices, n, dp),  // cooldown after sell
                               f(i+1, 0, prices, n, dp));
        }
        
        return dp[i][buy] = profit;
    }
}
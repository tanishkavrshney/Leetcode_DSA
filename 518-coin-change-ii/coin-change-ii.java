class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, amount, coins, dp);
    }

    private int helper(int i, int target, int[] coins, int[][] dp) {
        if (target == 0) return 1;  
        if (i == coins.length) return 0;

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = helper(i + 1, target, coins, dp);

        int take = 0;
        if (coins[i] <= target) {
            take = helper(i, target - coins[i], coins, dp);
        }

        return dp[i][target] = take + notTake;
    }
}
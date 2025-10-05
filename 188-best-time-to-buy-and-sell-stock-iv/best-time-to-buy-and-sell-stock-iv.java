class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp=new int[n][2][k+1];
        for(int[][] rows:dp) {
            for(int[] cows:rows)    
            Arrays.fill(cows,-1);
        }
        return f(0,1,k,prices,n,dp);
    }
    public int f(int i,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(cap==0 || i==n) return 0;

        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[i] + f(i+1,0,cap,prices,n,dp) , f(i+1,1,cap,prices,n,dp));
        }
        else{
            profit = Math.max(prices[i]+f(i+1,1,cap-1,prices,n,dp) , f(i+1,0,cap,prices,n,dp));
        }
        return dp[i][buy][cap]= profit;
    }
}
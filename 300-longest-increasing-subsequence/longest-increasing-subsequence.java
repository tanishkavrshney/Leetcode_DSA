class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int rows[]:dp) Arrays.fill(rows,-1);

        return f(0,-1,nums,nums.length,dp);        
    }
    public int f(int ind,int prev,int[] nums,int n,int[][] dp){
        if(ind==n) return 0;

        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int len = 0+f(ind+1,prev,nums,n,dp);
        if(prev==-1 || nums[ind]>nums[prev]){
            len=Math.max(len,1+f(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev+1]=len;
    }
}
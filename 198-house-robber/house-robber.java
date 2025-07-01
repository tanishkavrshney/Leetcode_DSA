class Solution {
    public int rob(int[] nums) {
        int[]dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length - 1,dp);
    }

    private int helper(int[] nums, int ind,int[]dp) {
        if (ind < 0) return 0;
        if (ind == 0) return nums[0];
        if(dp[ind] != -1) return dp[ind];

        int rob = nums[ind] + helper(nums, ind - 2,dp);
        int skip = helper(nums, ind - 1,dp);

        dp[ind]=Math.max(rob,skip);

        return dp[ind];
    }
}

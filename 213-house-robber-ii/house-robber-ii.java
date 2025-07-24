class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for(int i=0;i<n;i++){
            if(i!=0) temp1[i - 1] = nums[i];
            if(i!=n-1) temp2[i] = nums[i];
        }

        return Math.max(rob1(temp1), rob1(temp2));
    }
    public int rob1(int[] nums) {
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
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) return 0;

        int sum = (totalSum + target) / 2;

        int[][] dp = new int[nums.length][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countSubsets(nums, nums.length - 1, sum, dp);
    }
     private int countSubsets(int[] nums, int index, int sum, int[][] dp) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) return 2; // 0 can be +0 or -0
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }

        if (dp[index][sum] != -1) return dp[index][sum];

        int notPick = countSubsets(nums, index - 1, sum, dp);

        int pick = 0;
        if (sum >= nums[index]) {
            pick = countSubsets(nums, index - 1, sum - nums[index], dp);
        }

        return dp[index][sum] = pick + notPick;
    }
}
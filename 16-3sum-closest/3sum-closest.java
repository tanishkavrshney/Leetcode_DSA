class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int bestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return bestSum;
    }
}
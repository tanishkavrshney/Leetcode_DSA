class Solution {
    public int longestSubarray(int[] nums) {
        int count=0;
        int maxcount=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i-2]+nums[i-1]!=nums[i]){
                count=0;
                continue;
            }
            else{
                count++;
            }
            maxcount=Math.max(maxcount,count);
        }
        return maxcount+2;
    }
}
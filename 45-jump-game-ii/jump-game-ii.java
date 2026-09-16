class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
    return 0;
}
        int ans=0;
        int end=0;
        int farthest=0;
        for(int i=0;i<nums.length;i++){
            farthest = Math.max(farthest, nums[i] + i);

            if(farthest>=nums.length-1){
                ans++;
                return ans;
            }
            if(i==end){
                ans++;
                end=farthest;
            }
        }

        return ans;
    }
}
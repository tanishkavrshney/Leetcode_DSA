class Solution {
    public int removeElement(int[] nums, int val) {
        int j=nums.length-1;
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[a]=nums[i];
                //j--;
                a++;
            }
        }
        return a;
    }
}
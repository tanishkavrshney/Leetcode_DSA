class Solution {
    public int removeDuplicates(int[] nums) {
        int b=0;
        for(int i=0;i<nums.length;){
            int  n = nums[i];
            int a=0;
            while(i < nums.length && n==nums[i]){
                a++;
                if(a<=2){
                    nums[b]=nums[i];
                    b++;
                }
                i++;
            }
        }
        return b;
    }
}
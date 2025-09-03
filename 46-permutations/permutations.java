class Solution {
    private void find(List<List<Integer>> ans,List<Integer> subans,int i,int[] nums){
        if(i==nums.length){
            ans.add(new ArrayList(subans));
            return;
        }
        for(int idx=0;idx<=subans.size();idx++){
            if(!subans.contains(nums[i])){
            subans.add(idx,nums[i]);
            find(ans,subans,i+1,nums);
            subans.remove(idx);
            }

        }

        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        find(ans,new ArrayList(),0,nums);
        return ans;
    }
}
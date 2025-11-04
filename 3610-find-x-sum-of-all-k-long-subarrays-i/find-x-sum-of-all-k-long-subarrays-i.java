class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            ans[i]=f(i,i+k-1,nums,x);
            
        }
        return ans;
    }
    public int f(int start,int end,int[] nums,int x){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=start;i<=end;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }

        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        int sum = 0;
        for (int i = 0; i < Math.min(x, list.size()); i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }

        return sum;
    }
}
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> mp =new HashMap<>();

        for(int nums : arr){
            mp.put(nums,mp.getOrDefault(nums,0)+1);
        }
        int ans=-1;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            
            if (key == freq) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }
}
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int maxlen=0;
        for(int key: mp.keySet()){
            if(mp.containsKey(key+1)){
                maxlen=Math.max(maxlen,mp.get(key)+mp.get(key+1));
            }
        }
        return maxlen;
    }
}
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Step 1: count frequencies
        int maxFreq = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }
        
        // Step 2: sum frequencies of elements with maxFreq
        int ans = 0;
        for (int count : freq.values()) {
            if (count == maxFreq) {
                ans += count;
            }
        }
        
        return ans;
    }
}

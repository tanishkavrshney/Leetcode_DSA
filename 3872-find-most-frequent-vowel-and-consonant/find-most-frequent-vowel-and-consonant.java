class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        
        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Identify vowels
        String vowelSet = "aeiou";
        boolean[] isVowel = new boolean[26];
        for (char v : vowelSet.toCharArray()) {
            isVowel[v - 'a'] = true;
        }

        int maxVowel = 0, maxConsonant = 0;

        // Step 3: Find max vowel & consonant frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (isVowel[i]) {
                    maxVowel = Math.max(maxVowel, freq[i]);
                } else {
                    maxConsonant = Math.max(maxConsonant, freq[i]);
                }
            }
        }

        // Step 4: Return sum
        return maxVowel + maxConsonant;
    }
}

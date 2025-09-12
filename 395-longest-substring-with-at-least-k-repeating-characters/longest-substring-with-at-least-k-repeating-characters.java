// class Solution {
//     public int longestSubstring(String s, int k) {
//         return hehe(s,0,s.length(),k);
//     }
//     public int hehe(String s,int start,int end,int k){
//         int[] freq=new int[26];
//         for(int i=0;i<s.length();i++){
//             freq[s.charAt(i)-'a']++;
//         }
//         for(int i=start;i<end;i++){
//             if(freq[s.charAt(i)-'a']<k){
//                 int j=i+1;
//                 while(j<end && freq[s.charAt(j)-'a']<k){
//                     j++;
//                 }
//                 return Math.max(hehe(s,start,i,k),hehe(s,j,end,k));
//             }
//         }
//         return end-start;
//     }
// }

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0; // substring too small

        // frequency count
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // check each char
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                // skip all consecutive invalid chars
                while (j < end && freq[s.charAt(j) - 'a'] < k) j++;
                
                // divide at i, solve left and right
                return Math.max(helper(s, start, i, k),
                                helper(s, j, end, k));
            }
        }

        // all characters valid
        return end - start;
    }
}

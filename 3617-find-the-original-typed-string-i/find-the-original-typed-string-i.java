class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;

        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            int groupLength = j - i;
            if (groupLength >= 2) {
                ans += (groupLength - 1);
            }

            i = j;
        }

        return ans;
    }
}

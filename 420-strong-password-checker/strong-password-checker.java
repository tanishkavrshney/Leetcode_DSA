class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean lower = false, upper = false, digit = false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            else if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
        }
        int missing = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);

        if (n < 6) {
            return Math.max(missing, 6 - n);
        }

        // Count repeating runs and replacements needed
        int replacements = 0;
        int[] buckets = new int[3]; // counts of runs with len%3 == 0,1,2
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            int len = j - i;
            if (len >= 3) {
                replacements += len / 3;
                buckets[len % 3] += 1;
            }
            i = j;
        }

        if (n <= 20) {
            return Math.max(missing, replacements);
        }

        int deleteCount = n - 20;
        int toDelete = deleteCount;

        // Greedily use deletions where they reduce replacements most:
        // first runs with len%3==0 (1 deletion reduces one replacement),
        // then len%3==1 (2 deletions reduce one), then len%3==2 (3 deletions reduce one).
        for (int k = 0; k < 3 && toDelete > 0; ++k) {
            int need = k + 1;
            int use = Math.min(buckets[k], toDelete / need);
            toDelete -= use * need;
            replacements -= use;
        }

        // Any remaining deletions reduce replacements by floor(toDelete/3)
        if (toDelete > 0) {
            replacements -= toDelete / 3;
        }

        replacements = Math.max(0, replacements);

        return deleteCount + Math.max(missing, replacements);
    }
}

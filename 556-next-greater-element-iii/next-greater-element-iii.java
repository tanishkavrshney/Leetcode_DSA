class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        // Step 1: find first decreasing element
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) return -1; // already max

        // Step 2: find element just larger than digits[i]
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: reverse suffix
        reverse(digits, i + 1, digits.length - 1);

        // Step 5: convert back
        long ans = Long.parseLong(new String(digits));
        return (ans > Integer.MAX_VALUE) ? -1 : (int) ans;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}

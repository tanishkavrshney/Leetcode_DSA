class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        List<Set<Integer>> swapSets = new ArrayList<>();

        for (int num : nums) {
            swapSets.add(generateSwaps(num));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (swapSets.get(i).contains(nums[j]) || swapSets.get(j).contains(nums[i])) {
                    count++;
                }
            }
        }

        return count;
    }
     private Set<Integer> generateSwaps(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Set<Integer> swaps = new HashSet<>();
        swaps.add(num);

        int len = digits.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(digits, i, j);
                swaps.add(Integer.parseInt(new String(digits)));
                swap(digits, i, j);
            }
        }

        return swaps;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
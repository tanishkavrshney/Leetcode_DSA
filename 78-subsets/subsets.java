class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        generateSubsets(nums, 0, subset, result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        generateSubsets(nums, index + 1, current, result);

        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, result);

        current.remove(current.size() - 1);
    }
}

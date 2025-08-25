class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int idx = 0;

        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> intermediate = new ArrayList<>();

            int r = (d < n) ? 0 : d - n + 1;
            int c = (d < n) ? d : n - 1;

            while (r < m && c >= 0) {
                intermediate.add(mat[r][c]);
                r++;
                c--;
            }

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int num : intermediate) {
                result[idx++] = num;
            }
        }

        return result;
    }
}

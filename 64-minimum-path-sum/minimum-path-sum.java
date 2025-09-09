// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;

//         int[][] dp = new int[m][n];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return countPaths(m-1,n-1,dp,grid);
        
//     }
    

//     private static final int INF = 1_000_000_000;
    
//     public int countPaths(int i,int j,int[][] dp,int[][] a){
//         if(i==0 && j==0) return a[0][0];
//         if (i < 0 || j < 0) return INF;

//         if(dp[i][j] != -1) return dp[i][j];

//         int left = a[i][j] + countPaths(i-1,j,dp,a);
//         int right = a[i][j] + countPaths(i,j-1,dp,a);

//         return dp[i][j] = a[i][j] + Math.min(left,right);
//     }
// }



import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(m - 1, n - 1, grid, dp);
    }

    private static final int INF = 1_000_000_000;

    private int dfs(int i, int j, int[][] a, int[][] dp) {
        if (i == 0 && j == 0) return a[0][0];
        if (i < 0 || j < 0) return INF;

        if (dp[i][j] != -1) return dp[i][j];

        int up = dfs(i - 1, j, a, dp);
        int left = dfs(i, j - 1, a, dp);

        return dp[i][j] = a[i][j] + Math.min(up, left);
    }
}

// class Solution {
//     public int numEnclaves(int[][] grid) {
//         int[][] vis = new int[grid.length][grid[0].length];
//         for(int i=0;i<grid[0].length;i++){
//             if(grid[0][i]==1 ){
//                 dfs(0,i,grid,vis);
//             }
//             if(grid[grid.length-1][i]==1){
//                 dfs(grid[0].length-1,i,grid,vis);
//             }
//         }
//         for(int i=0;i<grid.length;i++){
//             if(grid[i][0]==1 ){
//                 dfs(i,0,grid,vis);
//             }
//             if(grid[i][grid[0].length-1]==1){
//                 dfs(i,grid[0].length-1,grid,vis);
//             }
//         }
//         int c=0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j]==1 && vis[i][j]==0){
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
//     public void dfs(int i,int j,int[][] grid,int[][] vis){
//         vis[i][j]=1;

//         int[] delrow = {-1,0,1,0};
//         int[] delcol = {0,1,0,-1};

//         for(int k=0; k<4;k++){
//            int newRow = i + delrow[k];
//            int newCol = j + delcol[k];

//            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length  && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
//                 dfs(newRow, newCol, grid, vis);
//             }
//         }
//     }
// }

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        // First and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) 
                dfs(0, j, grid, vis);
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) 
                dfs(n - 1, j, grid, vis);
        }

        // First and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) 
                dfs(i, 0, grid, vis);
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) 
                dfs(i, m - 1, grid, vis);
        }

        // Count unvisited land cells
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int n = grid.length, m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, grid, vis);
            }
        }
    }
}

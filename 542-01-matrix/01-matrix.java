class Pair {
    int row;
    int col;
    int steps;

    Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] vis = new int[mat.length][mat[0].length];
        int[][] dist = new int[mat.length][mat[0].length];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;

            q.remove();

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol, steps + 1));
                }
            }
               
        }
        return dist;
    }
}
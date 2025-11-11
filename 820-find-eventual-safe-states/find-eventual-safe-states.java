class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfscheck(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> safenodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                safenodes.add(i);
            }
        }
        return safenodes;
    }
    public boolean dfscheck(int node, int[][] graph,int[] vis,int[] pathvis,int[] check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;

        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfscheck(it, graph, vis, pathvis, check) == true) {
                    check[node] = 0;
                    return true;
                }
            }
            else if (pathvis[it] == 1) {
                check[node] = 0;
                return true;
            }
        }

        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }
}
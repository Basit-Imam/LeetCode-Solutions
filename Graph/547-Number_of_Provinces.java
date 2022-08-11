class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n + 1];
        vis[0] = true;
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(vis[i] == false){
                //at every new call, a component is added
                dfsComp(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }
    
    private void dfsComp(int[][] graph, int node, boolean[] vis){
        vis[node] = true;
        //neighbor's of node -> 0 to n if graph[node-1][i] == 1
        for(int i = 0; i < graph.length; i++){
            if(graph[node-1][i] == 1 && vis[i+1] == false){
                graph[node-1][i] = 0;
                dfsComp(graph, i+1, vis);
            }
        }
    }
}
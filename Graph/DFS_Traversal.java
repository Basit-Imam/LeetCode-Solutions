import java.util.ArrayList;

public class DFS_Traversal {

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> ls, boolean[] vis){
        vis[node] = true;
        ls.add(node);

        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(adj, it, ls, vis);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(adj, 0, ls, vis);
        return ls;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //let's consider 5 nodes : 0 to 4
        for(int i = 0; i < 5; i++){
            adj.add(new ArrayList<Integer>());
        }

        //map the neighbours
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}


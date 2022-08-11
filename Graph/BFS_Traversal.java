import java.util.*;

public class BFS_Traversal {

    public static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);

            //traverse all it's immediate neighbours, if neighbour is not visited then mark it as visited and enque it
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;

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

        ArrayList<Integer> ans = bfs(5, adj);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}

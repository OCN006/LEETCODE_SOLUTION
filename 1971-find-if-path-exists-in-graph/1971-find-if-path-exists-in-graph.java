class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0] , b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean [] vis = new boolean[n];
        dfs(start,adj,vis);
        // vis[start] = true;
        // Queue<Integer> q = new LinkedList<>();
        // q.add(start);
        // while(!q.isEmpty()){
        //     int front = q.remove();
        //     for(int ele : adj.get(front)){
        //         if(!vis[ele]){
        //             q.add(ele);
        //             vis[ele]=true;
        //         }
        //    }
        // }
        return vis[end];
    }
    static void dfs(int start , ArrayList<ArrayList<Integer>> adj , boolean [] vis){
        vis[start] = true;
        for(int ele : adj.get(start)){
            if(!vis[ele]){
                dfs(ele,adj,vis);
            }
        }
    }
}
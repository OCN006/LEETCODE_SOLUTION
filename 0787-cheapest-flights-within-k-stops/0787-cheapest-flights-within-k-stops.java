class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        List<int[]>[]adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] flight:flights){
            int u=flight[0],v=flight[1],w=flight[2];
            adj[u].add(new int[]{v,w});
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{src,0,0});
        
        while(!q.isEmpty()){
            int[]cell=q.poll();
            int node=cell[0];
            int dis=cell[1];
            int stops=cell[2];
            if(stops>k)continue;
            
            for(int[]nbrs:adj[node]){
                int nbr=nbrs[0];
                int wt=nbrs[1];
                int newDis=dis+wt;
                if(newDis<dist[nbr]){
                    dist[nbr]=newDis;
                    q.add(new int[]{nbr,newDis,stops+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
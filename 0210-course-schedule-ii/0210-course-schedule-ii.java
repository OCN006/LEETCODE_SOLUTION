class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if no cycle them return the topo sorted order
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[]row:prerequisites){
            adj.get(row[1]).add(row[0]);
        }
        ArrayList<Integer>ansTopo=new ArrayList<>();
        int[]visited=new int[numCourses];
        int[]currentPath=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,currentPath,ansTopo)){
                    //if at any point cycle detected just retun an empty int array
                    return new int[0];
                }
            }
        }
        int index=0;
        int[]ans=new int[ansTopo.size()];
        for(int i=ansTopo.size()-1;i>=0;i--){
            ans[index++]=ansTopo.get(i);
        }
        return ans;
    }
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,int[]visited,int[]currentPath,ArrayList<Integer>ansTopo){
        visited[node]=1;
        currentPath[node]=1;
        for(int cur:adj.get(node)){
            if(visited[cur]==0){
                if(dfs(cur,adj,visited,currentPath,ansTopo))return true;
            }else if(currentPath[cur]==1)return true;
        }
        currentPath[node]=0;
        ansTopo.add(node);
        return false;
    }
}
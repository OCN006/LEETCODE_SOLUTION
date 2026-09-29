class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int [][] ans = new int[k][2];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->(distance(b)-distance(a)));
        
        for(int [] point : points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
    public int distance(int [] p){
        return p[0]*p[0] + p[1]*p[1];
    }
}
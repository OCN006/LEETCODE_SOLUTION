class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        int oColor = image[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{0, 1}, {1, 0},{0, -1}, {-1, 0}};
        
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int[] dir : dirs){
                int r = dir[0] + cur[0];
                int c = dir[1] + cur[1];
                
                if(r >= 0 && r < image.length && c >= 0 && c < image[r].length && image[r][c] == oColor){
                    queue.offer(new int[]{r, c});
                    image[r][c] = color;
                }
            }
        }
        return image;
        
    }
}
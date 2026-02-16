class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] indegree = new int[graph.length];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        // Reverse the graph and calculate indegrees
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                adj.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int parent = que.poll();
            ans.add(parent);

            for (int node : adj.get(parent)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    que.add(node);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
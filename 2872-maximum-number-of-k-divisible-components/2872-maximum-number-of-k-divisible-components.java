import java.util.*;

class Solution {
    int ans = 0;
    int k;
    int[] values;
    List<List<Integer>> graph;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dfs(0, -1);

        return ans + 1;  // +1 final remaining component
    }

    private long dfs(int node, int parent) {
        long sum = values[node];

        for (int child : graph.get(node)) {
            if (child == parent) continue;

            long childSum = dfs(child, node);

            // If this subtree is divisible by k → CUT
            if (childSum % k == 0) {
                ans++;
            } else {
                sum += childSum;
            }
        }

        return sum;
    }
}

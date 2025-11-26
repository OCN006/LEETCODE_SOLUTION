class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] dpPrev = new int[n][k];

        for (int i = 0; i < m; i++) {
            int[][] dpCurr = new int[n][k];
            for (int j = 0; j < n; j++) {

                int val = grid[i][j] % k;

                if (i == 0 && j == 0) {
                    dpCurr[j][val] = 1;
                } else {

                    // From left
                    if (j > 0) {
                        for (int r = 0; r < k; r++) {
                            int newR = (r + val) % k;
                            dpCurr[j][newR] = (dpCurr[j][newR] + dpCurr[j - 1][r]) % MOD;
                        }
                    }

                    // From top
                    if (i > 0) {
                        for (int r = 0; r < k; r++) {
                            int newR = (r + val) % k;
                            dpCurr[j][newR] = (dpCurr[j][newR] + dpPrev[j][r]) % MOD;
                        }
                    }
                }
            }
            dpPrev = dpCurr;
        }

        return dpPrev[n - 1][0];
    }
}

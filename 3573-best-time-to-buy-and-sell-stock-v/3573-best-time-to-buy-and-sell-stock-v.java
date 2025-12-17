class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long NEG = Long.MIN_VALUE / 2;

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;
            dp[t][1] = NEG;
            dp[t][2] = NEG;
        }

        for (int price : prices) {
            for (int t = k; t >= 1; t--) {
                
                dp[t][0] = Math.max(dp[t][0], dp[t][1] + price);

                
                dp[t][0] = Math.max(dp[t][0], dp[t][2] - price);

                
                dp[t][1] = Math.max(dp[t][1], dp[t - 1][0] - price);

                
                dp[t][2] = Math.max(dp[t][2], dp[t - 1][0] + price);
            }
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}

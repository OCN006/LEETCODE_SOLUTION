class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int mid = k / 2;

        long baseProfit = 0;

        long[] orig = new long[n];
        long[] sellGain = new long[n];

        for (int i = 0; i < n; i++) {
            orig[i] = (long) strategy[i] * prices[i];
            baseProfit += orig[i];
            sellGain[i] = prices[i] - orig[i];
        }

        long[] prefOrig = new long[n + 1];
        long[] prefSell = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefOrig[i + 1] = prefOrig[i] + orig[i];
            prefSell[i + 1] = prefSell[i] + sellGain[i];
        }

        long ans = baseProfit;

        for (int l = 0; l + k <= n; l++) {
            long loss = prefOrig[l + mid] - prefOrig[l];
            long gain = prefSell[l + k] - prefSell[l + mid];
            ans = Math.max(ans, baseProfit - loss + gain);
        }

        return ans;
    }
}

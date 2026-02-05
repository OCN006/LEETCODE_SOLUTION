class Solution {
    public int[] constructTransformedArray(int[] A) {
        int n = A.length, bias = n * (99 / n) + n;
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            res[i] = A[(i + A[i] + bias) % n];

        return res;
    }
}

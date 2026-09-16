class Solution {

    public int helper(int n , int[] dp){
        if(dp[n]!=-1) return dp[n];
        dp[n] = helper(n-1,dp)+helper(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        if(n<=1) return n;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        int ans = helper(n,dp);
        return ans;
    }
}
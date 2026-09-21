class Solution {
    //  recursion + memoization
    // public int helper(int [] dp , int n ){
    //     if(dp[n]!=-1) return dp[n];
    //     dp[n] = helper(dp,n-1)+helper(dp,n-2)+helper(dp,n-3);
    //     return dp[n];
    // }

    // tabulation
    public int tribonacci(int n) {
        if(n<=1) return n;
        if(n==2) return 1 ;
        int [] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        dp[0] =0 ; dp[1]=1 ; dp[2]=1;
        for(int i =3 ; i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        // return helper(dp,n);
        return dp[n];
    }
}
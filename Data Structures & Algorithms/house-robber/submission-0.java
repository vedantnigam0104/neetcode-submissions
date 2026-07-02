class Solution {
    public int rob(int[] cost) {
        int[] dp=new int[cost.length];

        Arrays.fill(dp,-1);

        return help(0,cost,dp);
    }
    int help(int ind,int[] cost,int[] dp)
    {
        if(ind>=cost.length)
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];

        int rob=cost[ind]+help(ind+2,cost,dp);

        int notrob=0 + help(ind+1,cost,dp);

        return dp[ind]=Math.max(rob,notrob);        
    }
}

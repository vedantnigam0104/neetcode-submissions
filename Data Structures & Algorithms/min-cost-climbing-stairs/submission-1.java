class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];

        Arrays.fill(dp,-1);

        return Math.min(help(0,cost,dp),help(1,cost,dp));
    }

    int help(int ind,int[] cost,int[] dp)
    {
        if(ind>=cost.length)
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];

        int take1=cost[ind] + help(ind+1,cost,dp);

        int take2=cost[ind] + help(ind+2,cost,dp);

        return dp[ind]=Math.min(take1,take2);        
    }
}

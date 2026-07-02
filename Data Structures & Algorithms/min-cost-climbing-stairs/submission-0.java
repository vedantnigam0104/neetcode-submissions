class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];

        Arrays.fill(dp,-1);

        return Math.min(help(0,cost,dp),help(1,cost,dp));
    }
    int help(int ind,int[] cost,int[] dp)
    {
        if(ind>=cost.length)
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];

        int one=cost[ind]+help(ind+1,cost,dp);

        int two=cost[ind]+help(ind+2,cost,dp);

        return dp[ind]=Math.min(one,two);        
    }
}

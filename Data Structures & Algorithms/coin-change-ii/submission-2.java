class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        return help(0,coins,amount,dp);    
    }
    int help(int ind,int[] coins,int amount,int[][] dp)
    {
        if(amount==0)
            return 1;

        if(ind>=coins.length)
            return 0;

        if(dp[ind][amount]!=-1)
            return dp[ind][amount];
        
        int take=0;

        if(amount>=coins[ind])
            take=help(ind,coins,amount-coins[ind],dp);

        int nottake=help(ind+1,coins,amount,dp);

        return dp[ind][amount]=take+nottake;
    }
}
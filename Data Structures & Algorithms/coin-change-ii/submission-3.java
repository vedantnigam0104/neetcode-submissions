class Solution {
    public int change(int amount, int[] coins) {
       int[][] dp=new int[coins.length][amount+1];

       for(int[] d : dp)
        Arrays.fill(d,-1);

       return help(0,coins,dp,amount);  
    }
    int help(int ind,int[] coins,int[][] dp,int amount)
    {
        if(ind>=coins.length)
            return 0;

        if(amount==0)
            return 1;

        if(dp[ind][amount]!=-1)
            return dp[ind][amount];

        int nottake=0 + help(ind+1,coins,dp,amount);

        int take=0;

        if(amount>=coins[ind])
        {
            take=help(ind,coins,dp,amount-coins[ind]);
        }

        return dp[ind][amount]=take+nottake;            
    }
}

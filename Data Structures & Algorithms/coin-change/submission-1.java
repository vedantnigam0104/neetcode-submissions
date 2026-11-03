class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];

        for(int[] d : dp)
        {
            Arrays.fill(d,-1);
        }

        int ans=help(0,coins,amount,dp);

        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int help(int ind,int[] coins,int amount,int[][] dp)
    {
        if(ind==coins.length-1)
        {
            if(amount%coins[ind]==0)
                return amount/coins[ind];
            else
                return Integer.MAX_VALUE;    
        }

        if(dp[ind][amount]!=-1)
            return dp[ind][amount];

        int nottake=help(ind+1,coins,amount,dp);

        int take=Integer.MAX_VALUE;

        if(amount>=coins[ind])
        {
            int res=help(ind,coins,amount-coins[ind],dp);

            if(res!=Integer.MAX_VALUE)
                take=1 + res;
        } 

        return dp[ind][amount]=Math.min(take,nottake);            
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        return help(0,prices,dp,0);    
    }
    int help(int ind,int[] prices,int[][] dp,int buy)
    {
        if(ind>=prices.length)
            return 0;

        if(dp[ind][buy]!=-1)
            return dp[ind][buy];

        int ans;    

        if(buy==0)
        {
            int take=-prices[ind] + help(ind+1,prices,dp,1);

            int nottake=0 + help(ind+1,prices,dp,0);

            ans=Math.max(take,nottake);
        }
        else
        {
            int sell=prices[ind] + help(ind+2,prices,dp,0);

            int notsell=0 + help(ind+1,prices,dp,1);

            ans=Math.max(sell,notsell);
        }
        return dp[ind][buy]=ans;
    }
}

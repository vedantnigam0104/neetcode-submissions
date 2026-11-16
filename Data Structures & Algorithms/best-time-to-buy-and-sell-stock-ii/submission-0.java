class Solution {
    public int maxProfit(int[] prices) {
      int n=prices.length;

      int[][] dp=new int[n][2];

      for(int i=0;i<n;i++)
      {
        for(int j=0;j<=1;j++)
        {
            dp[i][j]=-1;
        }
      }

      return help(0,prices,dp,0);    
    }
 
    int help(int ind,int[] prices,int[][] dp,int buy)
    {
        if(ind>=prices.length)
            return 0;

        if(dp[ind][buy]!=-1)
            return dp[ind][buy];

        if(buy==0)
        {
            int take=-prices[ind]+help(ind+1,prices,dp,1);

            int nottake=0 + help(ind+1,prices,dp,0);

            return dp[ind][buy]=Math.max(take,nottake);
        }
        else
        {
            int sell=prices[ind]+help(ind+1,prices,dp,0);

            int notsell=0+help(ind+1,prices,dp,1);

            return dp[ind][buy]=Math.max(sell,notsell);
        }        
    }
}
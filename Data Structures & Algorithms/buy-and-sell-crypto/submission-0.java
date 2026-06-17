class Solution 
{
    public int maxProfit(int[] prices) 
    {
       int cp=prices[0];

       int profit=0;

       for(int i=1;i<prices.length;i++)
       {
            profit=Math.max(profit,prices[i]-cp);

            cp=Math.min(cp,prices[i]);
       }
       return profit;     
    }
}

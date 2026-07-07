class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int[][] dp=new int[s.length()][t.length()];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        return help(0,0,s,t,dp);    
    }
    int help(int i,int j,String s,String t,int[][] dp)
    {
        if(j==t.length())
            return 1;

        if(i==s.length())
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j]; 

        if(s.charAt(i)==t.charAt(j))
        {
            dp[i][j]=help(i+1,j+1,s,t,dp) + help(i+1,j,s,t,dp);
        }
        else
        {
            dp[i][j]=help(i+1,j,s,t,dp);
        }
        return dp[i][j];               
    }
}

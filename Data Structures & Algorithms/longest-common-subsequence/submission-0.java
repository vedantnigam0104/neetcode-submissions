class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp=new int[t1.length()][t2.length()];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        return help(t1.length()-1,t2.length()-1,t1,t2,dp);    
    }
    int help(int i,int j,String t1,String t2,int[][] dp)
    {
        if(i<0 || j<0)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        if(t1.charAt(i)==t2.charAt(j))
        {
            return dp[i][j]=1 + help(i-1,j-1,t1,t2,dp);
        }
        else
        {
            return dp[i][j]=Math.max(help(i-1,j,t1,t2,dp),help(i,j-1,t1,t2,dp));
        }            
    }
}

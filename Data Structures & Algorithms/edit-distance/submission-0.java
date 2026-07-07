class Solution {
    public int minDistance(String word1, String word2) {
     int m=word1.length();

     int n=word2.length();

     int[][] dp=new int[m][n];

     for(int[] d : dp)
        Arrays.fill(d,-1);

      return help(0,0,word1,word2,dp);     
    }
    int help(int i,int j,String word1,String word2,int[][] dp)
    {
        if(i==word1.length())
            return word2.length()-j;
        if(j==word2.length())
            return word1.length()-i; 
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))
            return dp[i][j]=help(i+1,j+1,word1,word2,dp);
        else
        {
            int ins=1 + help(i+1,j,word1,word2,dp);

            int del=1 + help(i,j+1,word1,word2,dp);

            int rep=1 + help(i+1,j+1,word1,word2,dp);

            return dp[i][j]=Math.min(ins,Math.min(del,rep));
        }               
    }
}

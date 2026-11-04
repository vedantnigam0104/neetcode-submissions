class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dp=new int[m][n];

      for(int[] d : dp)
        Arrays.fill(d,-1);

      return help(0,0,m,n,dp);    
    }
    int help(int i,int j,int m,int n,int[][] dp)
    {
        if(i==m-1 && j==n-1)
            return 1;

        if(i>=m || j>=n)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int down=help(i+1,j,m,n,dp);

        int right=help(i,j+1,m,n,dp);

        return dp[i][j]=down+right;            
    }
}

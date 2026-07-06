class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        return help(0,0,dp,m,n);    
    }
    int help(int i,int j,int[][] dp,int m,int n)
    {
        if(i>=m || j>=n)
            return 0;

        if(i==m-1 && j==n-1)
            return 1;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int down=help(i+1,j,dp,m,n);

        int right=help(i,j+1,dp,m,n);

        return dp[i][j]=down+right;            
    }
}

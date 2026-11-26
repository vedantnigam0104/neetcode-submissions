class Solution {
    public int tribonacci(int n) {
       if(n==0)
        return 0;

       if(n==1)
            return 1;

       if(n==2)
            return 1;

       long[] dp=new long[n+1];

       dp[0]=0;

       dp[1]=1;

       dp[2]=1;

       for(int i=3;i<=n;i++)
       {
            dp[i]=(long)dp[i-1]+dp[i-2]+dp[i-3];
       } 
       return (int)dp[n];
    }
}
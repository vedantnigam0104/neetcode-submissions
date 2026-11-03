class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];

        Arrays.fill(dp,-1);

        return help(0,s,dp);
    }
    int help(int ind,String s,int[] dp)
    {
        if(ind==s.length())
            return 1;

        if(s.charAt(ind)=='0')
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];

        int ways=help(ind+1,s,dp);

        if(ind+1<s.length())
        {
            int num=(s.charAt(ind)-'0')*10 + (s.charAt(ind+1)-'0');

            if(num>=10 && num<=26)
            {
                ways+=help(ind+2,s,dp);
            }
        }

        return dp[ind]=ways;            
    }
}

class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];

        Arrays.fill(dp,-1);

        return help(0,nums,dp);
    }
    int help(int ind,int[] nums,int[] dp)
    {
        if(ind>=nums.length)
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];

        int take=nums[ind] + help(ind+2,nums,dp);

        int nottake=0 + help(ind+1,nums,dp);

        return dp[ind]=Math.max(take,nottake);        
    }
}

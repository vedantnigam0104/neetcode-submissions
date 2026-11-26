class Solution {
    public int rob(int[] nums) {
       if(nums.length==1)
        return nums[0];

       int[] dp1=new int[nums.length];

       int[] dp2=new int[nums.length];

       Arrays.fill(dp1,-1);

       Arrays.fill(dp2,-1);

       return Math.max(help(0,nums.length-2,nums,dp1),help(1,nums.length-1,nums,dp2)); 
    }

    int help(int i,int j,int[] nums,int[] dp)
    {
        if(i>j)
            return 0;

        if(dp[i]!=-1)
            return dp[i];

        int rob=nums[i] + help(i+2,j,nums,dp);

        int notrob=0 + help(i+1,j,nums,dp);

        return dp[i]=Math.max(rob,notrob);        
    }
}

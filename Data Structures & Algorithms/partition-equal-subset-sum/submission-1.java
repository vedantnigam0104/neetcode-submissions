class Solution {
    public boolean canPartition(int[] nums) {
        int totsum=0;

        for(int num : nums)
            totsum+=num;

        if(totsum%2!=0)
            return false;

        int sum=totsum/2;

        int[][] dp=new int[nums.length][sum+1];

        for(int[] d : dp)
        {
            Arrays.fill(d,-1);
        }

        return help(0,nums,sum,dp);        
    }
    boolean help(int ind,int[] nums,int sum,int[][] dp)
    {
        if(sum==0)
            return true;

        if(ind==nums.length)
            return false;

        if(dp[ind][sum]!=-1)
            return dp[ind][sum]==1?true:false;

        boolean nottake=help(ind+1,nums,sum,dp);

        boolean take=false;

        if(sum>=nums[ind])
            take=help(ind+1,nums,sum-nums[ind],dp);

        dp[ind][sum]=(take || nottake)?1:0;

        return take || nottake;            
    }
}

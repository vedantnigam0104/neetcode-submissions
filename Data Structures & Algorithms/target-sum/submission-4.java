class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int tot=0;

       for(int n : nums)
        tot+=n;

       if(Math.abs(target)>tot)
        return 0;

       if((tot+target)%2!=0)
        return 0;

       int sum=(tot+target)/2;   

       int[][] dp=new int[nums.length][sum+1];

       for(int[] d : dp)
        Arrays.fill(d,-1);

       return help(0,nums,sum,dp);  
    }
    int help(int ind,int[] nums,int tar,int[][] dp)
    {
        if(ind==nums.length-1)
        {
            if(tar==0 && nums[ind]==0)
                return 2;

            if(tar==0 || nums[ind]==tar)
                return 1;

            return 0;        
        }

        if(dp[ind][tar]!=-1)
            return dp[ind][tar];

        int nottake=help(ind+1,nums,tar,dp);

        int take=0;

        if(tar>=nums[ind])
            take=help(ind+1,nums,tar-nums[ind],dp);

        return dp[ind][tar]=take+nottake;                
    }
}

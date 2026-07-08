class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int cursum=0;

        int maxsum=nums[0];

        for(int i : nums)
        {
            if(cursum<0)
                cursum=0;

            cursum+=i;

            maxsum=Math.max(maxsum,cursum);
        }
        return maxsum;    
    }
}

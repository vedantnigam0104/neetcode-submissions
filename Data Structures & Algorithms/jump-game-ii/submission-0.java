class Solution 
{
    public int jump(int[] nums) 
    {
       int jumps=0;

       int curend=0;

       int maxreach=0;

       for(int i=0;i<nums.length-1;i++)
       {
            maxreach=Math.max(maxreach,i+nums[i]);

            if(i==curend)
            {
                jumps++;

                curend=maxreach;
            }
       }
       return jumps; 
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int len=nums.length-k+1;

       int[] ans=new int[len];

       int max=-1;

       int ind=0;

       for(int i=0;i<=nums.length-k;i++)
       {
            for(int j=i;j<i+k;j++)
            {
                max=Math.max(max,nums[j]);
            }
            ans[ind++]=max;

            max=-1;
       }
       return ans; 
    }
}

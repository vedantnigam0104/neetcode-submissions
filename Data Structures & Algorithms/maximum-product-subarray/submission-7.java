class Solution {
    public int maxProduct(int[] nums) {
        int minprod=nums[0];

        int maxprod=nums[0];

        int ans=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int curr=nums[i];

            int newmax=Math.max(curr,Math.max(curr*maxprod,curr*minprod));

            int newmin=Math.min(curr,Math.min(curr*maxprod,curr*minprod));

            maxprod=newmax;

            minprod=newmin;

            ans=Math.max(ans,maxprod);
        }
        return ans;
    }
}

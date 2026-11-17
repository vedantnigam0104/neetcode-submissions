class Solution {
    public int firstMissingPositive(int[] nums) {
       List<Integer> li=new ArrayList<>();

       int min=Integer.MAX_VALUE;

       for(int i=0;i<nums.length;i++)
       {
            li.add(nums[i]);

            min=Math.min(min,nums[i]);
       } 

       int ans=0;

       for(int k=1;k<=nums.length+1;k++)
       {
            if(!li.contains(k))
            {
                ans=k;

                break;
            }
       }
       return ans;
    }
}
class Solution {
    public int search(int[] nums, int t) {
        int s=0;
        
        int e=nums.length-1;
        
        while(s<=e)
        {
            int mid=(s+e)/2;
            
            if(nums[mid]==t)
                return mid;
            
            if(nums[s]<=nums[mid])
            {
                if(nums[s]<=t && t<=nums[mid])
                    e=mid-1;
                else
                    s=mid+1;
            }
            else
            {
                if(nums[mid]<=t && t<=nums[e])
                    s=mid+1;
                else
                    e=mid-1;
            }
        }
        return -1;
    }
}

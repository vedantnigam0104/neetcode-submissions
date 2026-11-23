class Solution {
    public int splitArray(int[] nums, int k) {
        int max=0;

        int s=0;

        for(int num : nums)
        {
            max=Math.max(max,num);

            s+=num;
        }

        int l=max;

        int h=s;

        while(l<h)
        {
            int mid=l+(h-l)/2;

            int sum=0;

            int cnt=1;

            for(int num : nums)
            {
                if(sum+num>mid)
                {
                    cnt++;

                    sum=num;
                }
                else
                {
                    sum+=num;
                }
            }

            if(cnt<=k)
            {
                h=mid;
            }
            else
                l=mid+1;
        }
        return l;
    }
}
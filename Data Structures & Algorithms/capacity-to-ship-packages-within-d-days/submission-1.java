class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;

        int sum=0;

        for(int w : weights)
        {
            max=Math.max(max,w);

            sum+=w;
        }

        int l=max;

        int h=sum;

        while(l<=h)
        {
            int mid=(l+h)/2;

            if(canplace(weights,mid)<=days)
            {
                h=mid-1;
            }
            else
                l=mid+1;    
        }
        return l;
    }
    int canplace(int[] w,int mid)
    {
        int cnt=1;

        int curr=0;

        for(int i=0;i<w.length;i++)
        {
            if(curr+w[i]>mid)
            {
                cnt++;

                curr=w[i];
            }
            else
            {
                curr+=w[i];
            }
        }
        return cnt;
    }
}
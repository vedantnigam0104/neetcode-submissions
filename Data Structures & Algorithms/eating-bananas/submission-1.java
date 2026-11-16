class Solution {
    boolean caneat(int[] piles,int mid,int h)
    {
        int toth=0;

        for(int i=0;i<piles.length;i++)
        {
            toth+=Math.ceil((double)piles[i]/mid);
        }

        return toth<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;

        int min=Integer.MAX_VALUE;

        for(int i=0;i<piles.length;i++)
        {
            max=Math.max(max,piles[i]);

            min=Math.min(min,piles[i]);
        }

        int l=1;

        int hi=max;

        while(l<=hi)
        {
            int mid=(l+hi)/2;

            if(caneat(piles,mid,h))
            {
                hi=mid-1;
            }

            else
            {
                l=mid+1;
            }
        }
        return l;
    }
}

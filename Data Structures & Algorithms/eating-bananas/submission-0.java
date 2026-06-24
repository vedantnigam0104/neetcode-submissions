class Solution 
{
    int help(int[] p,int mid)
    {
        int tot=0;
        
        for(int i=0;i<p.length;i++)
        {
            tot+=Math.ceil((double)p[i]/(double)(mid));
        }
        return tot;
    }
    public int minEatingSpeed(int[] p, int b) 
    {
        int l=1;
        
        int h=0;
        
        for(int i : p)
            h=Math.max(h,i);
        
        while(l<=h)
        {
            int mid=(l+h)/2;
            
            int ans=help(p,mid);
            
            if(ans<=b)
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}

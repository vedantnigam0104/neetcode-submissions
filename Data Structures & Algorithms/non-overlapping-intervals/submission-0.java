class Solution 
{
    public int eraseOverlapIntervals(int[][] itr) 
    {
        Arrays.sort(itr,(a,b)->a[1]-b[1]);

        int cnt=0;

        int prev=itr[0][1];

        for(int i=1;i<itr.length;i++)
        {
            if(itr[i][0]<prev)
                cnt++;
            else
                prev=itr[i][1];    
        }
        return cnt;
    }
}
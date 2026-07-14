class Solution 
{
    public boolean isHappy(int n) 
    {
        List<Integer> vis=new ArrayList<>();

        int b=0;

        int s=0;

        while(n!=1)
        {
            if(vis.contains(n))
                return false;

            vis.add(n);

            b=n;

            while(b!=0)
            {
                int t=b%10;

                s+=t*t;

                b/=10;
            }

            n=s;

            s=0;
        }
        return true;
    }
}

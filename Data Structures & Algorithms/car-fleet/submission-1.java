class Solution {
    public int carFleet(int tar, int[] pos, int[] sp) {
        int fleets=0;

        double lastime=0.0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<pos.length;i++)
        {
            map.put(pos[i],sp[i]);
        }

        Arrays.sort(pos);

        for(int i=pos.length-1;i>=0;i--)
        {
            double time=(double)(tar-pos[i])/map.get(pos[i]);

            if(time>lastime)
            {
                fleets++;

                lastime=time;
            }
        }
        return fleets;
    }
}

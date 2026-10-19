class Pair
{
    int first;

    int second;

    Pair(int first,int second)
    {
        this.first=first;

        this.second=second;
    }
}
class Tuple
{
    int u;

    int v;

    int time;

    Tuple(int u,int v,int time)
    {
        this.u=u;

        this.v=v;

        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] t : times)
        {
            int u1=t[0];

            int v1=t[1];

            int t1=t[2];

            adj.get(u1).add(new Tuple(u1,v1,t1));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.second-b.second);

        int[] timer=new int[n+1];

        Arrays.fill(timer,Integer.MAX_VALUE);

        timer[k]=0;
    
        pq.add(new Pair(k,0));

        while(!pq.isEmpty())
        {
            int node=pq.peek().first;

            int time=pq.peek().second;

            pq.poll();

            if(time>timer[node])
                continue;

            for(Tuple it : adj.get(node))
            {
                int n2=it.v;

                int t=it.time;

                if(timer[node]+t<timer[n2])
                {
                    timer[n2]=timer[node]+t;

                    pq.add(new Pair(n2,timer[n2]));
                }
            }
        }
        int maxtime=0;

        for(int i=1;i<=n;i++)
        {
            if(timer[i]==Integer.MAX_VALUE)
                return -1;

            maxtime=Math.max(maxtime,timer[i]);    
        }
        return maxtime;
    }
}

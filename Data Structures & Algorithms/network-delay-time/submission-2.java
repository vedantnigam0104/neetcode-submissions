class Pair
{
    int first;

    int second;

    int time;

    Pair(int first,int second,int time)
    {
        this.first=first;

        this.second=second;

        this.time=time;
    }
}

class Tuple
{
    int node1;

    int time1;

    Tuple(int node1,int time1)
    {
        this.node1=node1;

        this.time1=time1;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] t : times)
        {
            int u=t[0];

            int v=t[1];

            int ti=t[2];

            adj.get(u).add(new Pair(u,v,ti));
        }

        int[] dist=new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.time1-b.time1);

        pq.add(new Tuple(k,0));

        dist[k]=0;

        while(!pq.isEmpty())
        {
            int node=pq.peek().node1;

            int sec=pq.peek().time1;

            pq.poll();

            if(sec>dist[node])
                continue;

            for(Pair it : adj.get(node))
            {
                int adjnode=it.second;

                int adjtime=it.time;

                if(dist[adjnode]>adjtime+sec)
                {
                    dist[adjnode]=adjtime+sec;

                    pq.add(new Tuple(adjnode,dist[adjnode]));
                }
            }
        }
        int ans=0;

        for(int ind=1;ind<=n;ind++)
        {
            if(dist[ind]==Integer.MAX_VALUE)
                return -1;

            ans=Math.max(ans,dist[ind]);    
        }
        return ans;
    }
}

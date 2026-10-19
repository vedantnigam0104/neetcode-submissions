class Pair
{
    int node;

    int price;

    Pair(int node,int price)
    {
        this.node=node;

        this.price=price;
    }
}

class Tuple
{
    int source;

    int pr;

    int stops;

    Tuple(int source,int pr,int stops)
    {
        this.source=source;

        this.pr=pr;

        this.stops=stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights)
        {
            int u=f[0];

            int v=f[1];

            int w=f[2];

            adj.get(u).add(new Pair(v,w));
        }

        Queue<Tuple> pq=new LinkedList<>();

        pq.add(new Tuple(src,0,0));

        int[] dist=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        while(!pq.isEmpty())
        {
            int no=pq.peek().source;

            int p=pq.peek().pr;

            int stops=pq.peek().stops;

            pq.poll();

            if(stops>k)
                continue;    

            for(Pair it : adj.get(no))
            {
                int n1=it.node;

                int p1=it.price;

                if(p+p1<dist[n1] && stops<=k)
                {
                    dist[n1]=p+p1;

                    pq.add(new Tuple(n1,dist[n1],stops+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}

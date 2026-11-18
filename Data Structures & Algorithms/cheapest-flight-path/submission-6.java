class Tuple
{
    int source;

    int price;

    int stops;

    Tuple(int source,int price,int stops)
    {
        this.source=source;

        this.price=price;

        this.stops=stops;
    }
}

class Pair
{
    int s;

    int d;

    int p;

    Pair(int s,int d,int p)
    {
        this.s=s;

        this.d=d;

        this.p=p;
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

            int pr=f[2];

            adj.get(u).add(new Pair(u,v,pr));
        }

        Queue<Tuple> pq=new LinkedList<>();

        pq.add(new Tuple(src,0,0));

        int[] cost=new int[n];

        Arrays.fill(cost,Integer.MAX_VALUE);

        cost[src]=0;

        while(!pq.isEmpty())
        {
            int s1=pq.peek().source;

            int p1=pq.peek().price;

            int st=pq.peek().stops;

            pq.poll();

            if(st>k)
                continue;

            for(Pair it : adj.get(s1))
            {
                int de=it.d;

                int p3=it.p;

                if(p1+p3<cost[de] && st<=k)
                {
                    cost[de]=p1+p3;

                    pq.add(new Tuple(de,cost[de],st+1));
                }
            }    
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}

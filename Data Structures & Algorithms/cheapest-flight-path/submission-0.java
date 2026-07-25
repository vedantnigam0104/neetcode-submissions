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
    int stops;
    
    int node;
    
    int cost;
    
    Tuple(int stops,int node,int cost)
    {
        this.stops=stops;
        
        this.node=node;
        
        this.cost=cost;
    }
}
class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        List<List<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int m=flights.length;
        
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        Queue<Tuple> q=new LinkedList<>();
        
        q.add(new Tuple(0,src,0));
        
        int[] dist=new int[n];
        
        Arrays.fill(dist,(int)(1e8));
        
        dist[src]=0;
        
        while(!q.isEmpty())
        {
            int stops=q.peek().stops;
            
            int node=q.peek().node;
            
            int cost=q.peek().cost;
            
            q.poll();
            
            if(stops>k)
                continue;
            
            for(Pair it : adj.get(node))
            {
                int adjnode=it.first;
                
                int edgewt=it.second;
                
                if(cost+edgewt<dist[adjnode] && stops<=k)
                {
                    dist[adjnode]=cost+edgewt;
                    
                    q.add(new Tuple(stops+1,adjnode,dist[adjnode]));
                }
            }
        }
        if(dist[dst]==(int)(1e8))
            return -1;
        return dist[dst];
    }
}
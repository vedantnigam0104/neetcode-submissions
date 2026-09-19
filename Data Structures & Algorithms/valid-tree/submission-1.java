public class Solution 
{
    public boolean validTree(int n, int[][] edges)
    {
        if(edges.length!=n-1)
            return false;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges)
        {
            adj.get(e[0]).add(e[1]);

            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis=new boolean[n];

        dfs(0,-1,adj,vis);

        for(int i=0;i<n;i++)
        {
            if(!vis[i])
                return false;
        }

        return true;    
    }

    void dfs(int node,int parent,List<List<Integer>> adj,boolean[] vis)
    {
        vis[node]=true;

        for(int adjn : adj.get(node))
        {
            if(adjn==parent)
                continue;

            if(vis[adjn])
                return;

            dfs(adjn,node,adj,vis);        
        }
    }
}
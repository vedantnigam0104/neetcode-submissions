class Solution {
    int[] parent;

    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent=new int[n];

        rank=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;

            rank[i]=1;
        }

        int cnt=n;

        for(int[] ed : edges)
        {
            int u=ed[0];

            int v=ed[1];

            if(findpar(parent,u)!=findpar(parent,v))
            {
                union(u,v);

                cnt--;
            }
        }
        return cnt;
    }
    int findpar(int[] par,int x)
    {
        if(par[x]!=x)
        {
            par[x]=findpar(par,par[x]);
        }

        return par[x];
    }

    void union(int u,int v)
    {
        int pu=findpar(parent,u);

        int pv=findpar(parent,v);

        if(pu==pv)
            return;

        if(rank[pu]>rank[pv])
        {
            parent[pv]=pu;
        }
        else if(rank[pv]>rank[pu])
        {
            parent[pu]=pv;
        }
        else
        {
            parent[pv]=pu;

            rank[pu]++;
        }
        return;    
    }
}

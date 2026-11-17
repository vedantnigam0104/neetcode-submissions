class Solution {
    int[] par;

    int[] rank;
    public int countComponents(int n, int[][] edges) {
        par=new int[n];

        rank=new int[n];

        int cnt=n;

        for(int i=0;i<n;i++)
        {
            par[i]=i;

            rank[i]=1;
        }

        for(int[] ed : edges)
        {
            int u1=ed[0];

            int v1=ed[1];

            if(findpar(par,u1)!=findpar(par,v1))
            {
                union(u1,v1);

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
        int pu=findpar(par,u);

        int pv=findpar(par,v);

        if(pu==pv)
            return;
        else
        {
            if(rank[pu]>rank[pv])
            {
                par[pv]=pu;
            }
            else if(rank[pv]>rank[pu])
            {
                par[pu]=pv;
            }
            else
            {
                par[pv]=pu;

                rank[pu]++;
            }
        }
        return;        
    }
}

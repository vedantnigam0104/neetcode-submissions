public class Solution {
    public int countComponents(int n, int[][] edges) {

        int cnt=0; 
        List<List<Integer>> adj=new ArrayList<>(); 
        for(int i=0;i<n;i++) 
        { 
            adj.add(new ArrayList<>()); 
        } 
        boolean[] vis=new boolean[n]; 
        for(int[] e : edges) 
        {
             adj.get(e[0]).add(e[1]); 
             adj.get(e[1]).add(e[0]); 
        } 
        for(int i=0;i<n;i++) 
        { 
            if(!vis[i]) 
            { 
                cnt++; 
                dfs(adj,vis,i); 
                } 
            } 
            return cnt; 
        } 
            void dfs(List<List<Integer>> adj,boolean[] vis,int node) 
            { 
                vis[node]=true; 
                for(int adjnode : adj.get(node)) 
                { 
                    if(!vis[adjnode])
                        dfs(adj,vis,adjnode); 
                } 
                    return; 
            } 
        }   
class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] p : pre)
        {
            int u=p[0];

            int v=p[1];

            adj.get(u).add(v);

            indegree[v]++;
        }

        List<Integer> res=new ArrayList<>();

        Queue<Integer> pq=new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                pq.add(i);

                res.add(i);
            }
        }

        while(!pq.isEmpty())
        {
            int node=pq.poll();

            for(int adjn : adj.get(node))
            {
                indegree[adjn]--;

                if(indegree[adjn]==0)
                {
                    pq.add(adjn);

                    res.add(adjn);
                }
            }
        }

        return res.size()==numCourses?true:false;
    }
}

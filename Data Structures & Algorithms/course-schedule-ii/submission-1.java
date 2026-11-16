class Solution {
    public int[] findOrder(int num, int[][] pre) {
      List<List<Integer>> adj=new ArrayList<>();

      for(int i=0;i<num;i++)
        adj.add(new ArrayList<>());

      int[] indeg=new int[num];  

      for(int[] p : pre)
      {
        adj.get(p[1]).add(p[0]);

        indeg[p[0]]++;
      }

      Queue<Integer> pq=new LinkedList<>();

      List<Integer> li=new ArrayList<>();

      for(int i=0;i<num;i++)
      {
        if(indeg[i]==0)
        {
            li.add(i);

            pq.add(i);
        }
      }

      while(!pq.isEmpty())
      {
         int node=pq.poll();

         for(int adjn : adj.get(node))
         {
            indeg[adjn]--;

            if(indeg[adjn]==0)
            {
                pq.add(adjn);

                li.add(adjn);
            }
         }
      }

      int[] ans=new int[li.size()];

      for(int j=0;j<li.size();j++)
      {
            ans[j]=li.get(j);
      }

      if(li.size()!=num)
        return new int[]{};

      return ans;     
    }
}

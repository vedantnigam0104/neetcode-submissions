class Solution {
    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj=new ArrayList<>();

      for(int i=0;i<26;i++)
      {
            adj.add(new ArrayList<>());
      }

      int[] indeg=new int[26];

      boolean[] vis=new boolean[26];

      for(String str : words)
      {
            for(char ch : str.toCharArray())
            {
                vis[ch-'a']=true;
            }
      }

      for(int i=0;i<words.length-1;i++)
      {
            String s1=words[i];

            String s2=words[i+1];

            int len=Math.min(s1.length(),s2.length());

            boolean f=false;

            for(int j=0;j<len;j++)
            {
                char ch=s1.charAt(j);

                char ch1=s2.charAt(j);

                if(ch!=ch1)
                {
                    adj.get(ch-'a').add(ch1-'a');

                    indeg[ch1-'a']++;

                    f=true;

                    break;
                }
            }
            if(s1.length()>s2.length() && !f)
                return "";
        }
        String ans=topo(adj,indeg,vis);

        return ans;
    }
    String topo(List<List<Integer>> adj,int[] indeg,boolean[] vis)
    {
        String ans="";

        Queue<Integer> pq=new LinkedList<>();

        for(int i=0;i<26;i++)
        {
            if(indeg[i]==0 && vis[i]==true)
                pq.add(i);
        }

        while(!pq.isEmpty())
        {
            int node=pq.poll();

            ans+=(char)(node+'a');

            for(int adjn : adj.get(node))
            {
                indeg[adjn]--;

                if(indeg[adjn]==0)
                {
                    pq.add(adjn);
                }
            }
        }
        int tot=0;

        for(int i=0;i<vis.length;i++)
        {
            if(vis[i])
                tot++;
        }
        return ans.length()==tot?ans:"";
    }
}

class Solution
{
    public String foreignDictionary(String[] words)
    {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<26;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[26];

        boolean[] vis=new boolean[26];

        for(String word : words)
        {
            for(char ch : word.toCharArray())
            {
                vis[ch-'a']=true;
            }
        }

        for(int i=0;i<words.length-1;i++)
        {
            String s1=words[i];

            String s2=words[i+1];

            int min=Math.min(s1.length(),s2.length());

            boolean f=false;

            for(int j=0;j<min;j++)
            {
                char ch=s1.charAt(j);

                char ch1=s2.charAt(j);

                if(ch!=ch1)
                {
                    adj.get(ch-'a').add(ch1-'a');

                    indegree[ch1-'a']++;

                    f=true;

                    break;
                }
            }
            if(!f && s1.length()>s2.length())
                return "";
        }
        String ans=topo(adj,indegree,vis);

        return ans;
    }
    String topo(List<List<Integer>> adj,int[] indegree,boolean[] vis)
    {
        String ans="";

        Queue<Integer> pq=new LinkedList<>();

        for(int i=0;i<26;i++)
        {
            if(indegree[i]==0 && vis[i]==true)
                pq.offer(i);
        }

        while(!pq.isEmpty())
        {
            int node=pq.poll();

            ans+=(char)(node+'a');

            for(int neigh : adj.get(node))
            {
                indegree[neigh]--;

                if(indegree[neigh]==0)
                    pq.offer(neigh);
            }
        }
        int tot=0;

        for(int i=0;i<vis.length;i++)
        {
            if(vis[i])
                tot++;
        }

        if(tot!=ans.length())
            return "";

        return ans;    
    }
}
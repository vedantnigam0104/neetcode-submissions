class Solution
{
    List<Integer> topo(int V, List<List<Integer>> adj)
    {
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++)
        {
            if(indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);

            for(int it : adj.get(node))
            {
                indegree[it]--;

                if(indegree[it] == 0)
                    q.offer(it);
            }
        }

        return ans;
    }

    public String foreignDictionary(String[] words)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < 26; i++)
            adj.add(new ArrayList<>());

        boolean[] present = new boolean[26];

        // Mark characters that actually appear
        for(String word : words)
        {
            for(char ch : word.toCharArray())
                present[ch - 'a'] = true;
        }

        // Build graph
        for(int i = 0; i < words.length - 1; i++)
        {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for(int j = 0; j < len; j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            // Invalid case: abc comes before ab
            if(!found && s1.length() > s2.length())
                return "";
        }

        List<Integer> order = topo(26, adj);

        int uniqueChars = 0;
        for(boolean b : present)
            if(b) uniqueChars++;

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int node : order)
        {
            if(present[node])
            {
                sb.append((char)(node + 'a'));
                count++;
            }
        }

        // Cycle exists
        if(count != uniqueChars)
            return "";

        return sb.toString();
    }
}
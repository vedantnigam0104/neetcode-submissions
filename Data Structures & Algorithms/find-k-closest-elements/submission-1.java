class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];    
        });

        List<Integer> li=new ArrayList<>();

        for(int a : arr)
        {
            pq.add(new int[]{Math.abs(a-x),a});        
        }

        while(!pq.isEmpty() && ans.size()<k)
        {
            int[] curr=pq.poll();

            int ele=curr[1];

            ans.add(ele);
        }

        Collections.sort(ans);

        return ans;
    }
}
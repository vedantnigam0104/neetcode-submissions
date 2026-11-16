class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int[] ans=new int[k];

       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]); 

       Map<Integer,Integer> map=new HashMap<>();

       for(int num : nums)
       {
            map.put(num,map.getOrDefault(num,0)+1);
       }

       for(int key : map.keySet())
       {
            pq.add(new int[]{map.get(key),key});
       }

       int ind=0;

       while(k!=0)
       {
            int[] curr=pq.poll();

            int freq=curr[0];

            int ele=curr[1];

            ans[ind++]=ele;

            k--;
       }
       return ans;
    }
}

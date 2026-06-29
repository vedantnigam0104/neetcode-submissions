class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        int cnt=1;

        for(int i : nums)
            pq.offer(i);

        while(cnt!=k)
        {
            pq.poll();

            cnt++;
        }
        return pq.isEmpty()?0:pq.peek();    
    }
}

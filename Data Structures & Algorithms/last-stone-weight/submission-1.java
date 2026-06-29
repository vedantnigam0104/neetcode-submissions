class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int i : stones)
            pq.offer(i);

        while(pq.size()>1)
        {
            int a =pq.poll();

            int b=pq.poll();

            if(a==b)
                continue;
            else
                pq.offer(a-b);

            if(pq.size()==0)
                return 0;        
        }
        return pq.isEmpty()?0:pq.peek();    
    }
}

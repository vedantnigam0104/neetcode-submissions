class Solution {
    public int subarraySum(int[] nums, int k) {
       int sum=0;

       int l=0;

       Map<Integer,Integer> map=new HashMap<>();

       map.put(0,1);

       int cnt=0;

       while(l<nums.length)
       {
            sum+=nums[l];

            if(map.containsKey(sum-k))
            {
                cnt+=(map.get(sum-k));
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
           
            l++;
       } 
       return cnt;
    }
}
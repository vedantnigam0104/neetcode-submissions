class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        List<Integer> li=new ArrayList<>();

        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key : map.keySet())
        {
            if(map.get(key)>(n/3))
                li.add(key);
        }

        return li;
    }
}
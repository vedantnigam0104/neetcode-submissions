class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res=new ArrayList<>();

       List<Integer> li=new ArrayList<>();

       help(nums,res,li,new boolean[nums.length]);

       return res; 
    }
    void help(int[] nums,List<List<Integer>> res,List<Integer> li,boolean[] pick)
    {
        if(li.size()==nums.length)
        {
            res.add(new ArrayList<>(li));

            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!pick[i])
            {
                li.add(nums[i]);

                pick[i]=true;

                help(nums,res,li,pick);

                li.remove(li.size()-1);

                pick[i]=false;
        }
    }
}
}
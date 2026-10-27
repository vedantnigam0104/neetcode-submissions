class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res=new ArrayList<>();

       List<Integer> li=new ArrayList<>();

       help(0,res,li,nums);

       return res; 
    }
    void help(int ind,List<List<Integer>> res,List<Integer> li,int[] nums)
    {
        if(ind>=nums.length)
        {
            res.add(new ArrayList<>(li));

            return;
        }

        li.add(nums[ind]);

        help(ind+1,res,li,nums);

        li.remove(li.size()-1);

        help(ind+1,res,li,nums);
    }
}

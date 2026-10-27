class Solution {
    int s=0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();

        List<Integer> li=new ArrayList<>();

        help(nums,0,res,li,target);

        return res;
    }
    void help(int[] nums,int ind,List<List<Integer>> res,List<Integer> li,int tar)
    {
        
        if(s==tar)
        {
            res.add(new ArrayList<>(li));

            return;
        }

        if(ind>=nums.length || s>tar)
        {
            return;
        }


        s+=nums[ind];

        li.add(nums[ind]);

        help(nums,ind,res,li,tar);

        s-=nums[ind];

        li.remove(li.size()-1);

        help(nums,ind+1,res,li,tar);
    }
}

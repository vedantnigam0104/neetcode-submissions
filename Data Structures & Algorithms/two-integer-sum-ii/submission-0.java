class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int s=0;

       int l=0;

       int r=numbers.length-1;

       while(l<r)
       {
            s=numbers[l]+numbers[r];

            if(s>target)
                r--;
            else if(s<target)
                l++;
            else
                return new int[]{l+1,r+1};        
       }
       return new int[]{-1,-1};
    }
}

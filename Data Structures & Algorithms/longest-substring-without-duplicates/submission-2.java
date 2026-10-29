class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;

        int r=0;

        int max=0;

        Map<Character,Integer> map=new HashMap<>();

        while(r<s.length())
        {
            if(map.containsKey(s.charAt(r)))
            {
                if(map.get(s.charAt(r))>=l)
                {
                    l=map.get(s.charAt(r))+1;
                }
            }

            max=Math.max(max,r-l+1);

            map.put(s.charAt(r),r);

            r++;
        }
        return max;
    }
}

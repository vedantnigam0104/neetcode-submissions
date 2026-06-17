class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();

        int len=0;

        int j=0;

        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                if(map.get(s.charAt(i))>=j)
                    j=map.get(s.charAt(i))+1;
            }

            len=Math.max(len,i-j+1);

            map.put(s.charAt(i),i);
        }
        return len;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int cnt=0;

        int max=0;

        Set<Character> set=new HashSet<>();

        for(char ch : s.toCharArray())
        {
            set.add(ch);
        }

        for(char c : set)
        {
            int l=0;

            cnt=0;

            for(int r=0;r<s.length();r++)
            {
                if(s.charAt(r)==c)
                    cnt++;

                while((r-l+1)-cnt>k)
                {
                    if(s.charAt(l)==c)
                        cnt--;

                    l++;    
                }

                max=Math.max(max,r-l+1);    
            }
        }
        return max;
    }
}

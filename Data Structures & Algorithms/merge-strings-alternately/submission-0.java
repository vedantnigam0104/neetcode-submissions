class Solution {
    public String mergeAlternately(String word1, String word2) {
       String str="";

       boolean f=false;

       int ind1=0;

       int ind2=0;

       while(ind1<word1.length() && ind2<word2.length())
       {
            if(!f)
            {
                str+=word1.charAt(ind1);

                ind1++;

                f=true;
            }
            else
            {
                str+=word2.charAt(ind2);

                ind2++;

                f=false;
            }
       }

       while(ind1<word1.length())
       {
            str+=word1.charAt(ind1++);
       }

       while(ind2<word2.length())
       {
            str+=word2.charAt(ind2++);
       }

       return str;
    }
}
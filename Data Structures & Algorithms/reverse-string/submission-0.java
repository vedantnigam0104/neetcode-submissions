class Solution {
    public void reverseString(char[] s) {
        
        char[] s1=new char[s.length];

        int ind=0;

        for(int i=s.length-1;i>=0;i--)
        {
            s1[ind++]=s[i];
        }

        for(int i=0;i<s1.length;i++)
        {
            s[i]=s1[i];
        }
        return;
    }
}
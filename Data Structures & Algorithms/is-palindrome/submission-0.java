class Solution {
    public boolean isPalindrome(String s) {
        int st=0;

        int e=s.length()-1;

        s=s.toLowerCase();

        while(st<=e)
        {
            if(!Character.isLetterOrDigit(s.charAt(st))) {
                st++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(e))) {
                e--;
                continue;
            }
            if(s.charAt(st)!=s.charAt(e))
                return false;

            st++;

            e--;        
        }
        return true;
    }
}
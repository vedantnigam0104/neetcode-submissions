class Solution {
    public String longestCommonPrefix(String[] strs) {
       String res="";

       Arrays.sort(strs);

       int len=Math.min(strs[0].length(),strs[strs.length-1].length());

       int i=0;

       while(i<len && strs[0].charAt(i)==strs[strs.length-1].charAt(i))
        i++;

       res=strs[0].substring(0,i);

       return res; 
    }
}
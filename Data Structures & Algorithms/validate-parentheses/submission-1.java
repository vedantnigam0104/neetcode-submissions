class Solution {
    public boolean isValid(String s) {
        int n=s.length();

        int i=0;

        Stack<Character> st=new Stack<>();

        while(i<n)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                st.push(s.charAt(i));
            else
            {
                if(!st.isEmpty())
                {
                    if(st.peek()=='(' && s.charAt(i)==')')
                        st.pop();
                    else if(st.peek()=='[' && s.charAt(i)==']')
                        st.pop();
                    else if(st.peek()=='{' && s.charAt(i)=='}')
                        st.pop();
                    else 
                        return false;            
                }
                else
                    return false;    
            }
            i++;
        }
        return (st.isEmpty())?true:false;
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st=new Stack<>();

       for(String str : tokens)
       {
            if(str.equals("+"))
            {
                int a=st.pop();

                int b=st.pop();

                int res=a+b;

                st.push(res);
            }
            else if(str.equals("-"))
            {
                int a=st.pop();

                int b=st.pop();

                int res=b-a;

                st.push(res);
            }
            else if(str.equals("*"))
            {
                int a=st.pop();

                int b=st.pop();

                int res=a*b;

                st.push(res);
            }
            else if(str.equals("/"))
            {
                int a=st.pop();

                int b=st.pop();
                
                int res=b/a;

                st.push(res);
            }
            else
            {
                st.push(Integer.valueOf(str));
            }
          }
           return st.pop(); 
       }
    }

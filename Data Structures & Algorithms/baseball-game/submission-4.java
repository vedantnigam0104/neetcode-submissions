class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();

        for(String str : operations)
        {
            if(st.size()>=2 && str.equals("+"))
            {
                int a=st.pop();

                int b=st.peek();

                st.push(a);

                //st.push(b);

                st.push(b+a);
            }
            else if(!st.isEmpty() && str.equals("D"))
            {
                int a=st.peek();

                //st.push(a);

                st.push(a*2);
            }
            else if(!st.isEmpty() && str.equals("C"))
            {
                st.pop();
            }
            else
            {
                st.push(Integer.valueOf(str));
            }
        }
        int s=0;

        while(!st.isEmpty())
        {
            s+=st.pop();
        }

        return s;
    }
}
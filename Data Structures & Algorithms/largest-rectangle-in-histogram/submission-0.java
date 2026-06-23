class Solution {
    public int largestRectangleArea(int[] h) {
         int n = h.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i])
                st.pop();
            
            if (st.isEmpty())
                left[i] = 0;
            else
                left[i] = st.peek() + 1;
            
            st.push(i);
        }
        
        while (!st.isEmpty())
            st.pop();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i])
                st.pop();
            
            if (st.isEmpty())
                right[i] = n - 1;
            else
                right[i] = st.peek() - 1;
            
            st.push(i);
        }
        
        int max = 0; 
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] + 1) * h[i]);
        }
        
        return max;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       Stack<Double> st=new Stack<>();

       int[][] arr=new int[position.length][2];

       for(int i=0;i<position.length;i++)
       {
            arr[i][0]=position[i];

            arr[i][1]=speed[i];
       }

       Arrays.sort(arr,(a,b)->b[0]-a[0]);

       for(int i=0;i<arr.length;i++)
       {
            double time=(double)(target-arr[i][0])/arr[i][1];

            if(st.isEmpty() || st.peek()<time)
                st.push(time);    
       } 
       return st.size();
    }
}

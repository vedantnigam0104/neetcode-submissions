class Solution {
    public int trap(int[] height) {
        int[] p=new int[height.length];

        int[] s=new int[height.length];

        p[0]=height[0];

        s[s.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++)
        {
            p[i]=Math.max(p[i-1],height[i]);
        }

        for(int j=height.length-2;j>=0;j--)
        {
            s[j]=Math.max(s[j+1],height[j]);
        }

        int area=0;

        for(int i=0;i<height.length;i++)
        {
            area += Math.min(p[i],s[i])-height[i];
        }
        return area;
    }
}
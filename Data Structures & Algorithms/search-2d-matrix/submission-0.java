class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;

        int n=matrix[0].length;

        int[] a=new int[m*n];

        int ind=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[ind++]=matrix[i][j];
            }
        }

        int l=0;

        int h=a.length-1;

        while(l<=h)
        {
            int mid=(l+h)/2;

            if(a[mid]==target)
                return true;
            else if(a[mid]>target)
                h=mid-1;
            else
                l=mid+1;        
        }
        return false;
    }
}

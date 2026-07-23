public class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int c=0;
        
        int m=grid.length;
        
        int n=grid[0].length;
        
        boolean[][] visit=new boolean[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visit[i][j] && grid[i][j]=='1')
                {
                    c++;
                    
                    dfs(grid,i,j,visit);
                }
            }
        }
        return c;
    }
    public void dfs(char[][] grid,int row,int col,boolean[][] visit)
    {
        visit[row][col]=true;
        
        int[] delrow={-1,0,1,0};
        
        int[] delcol={0,1,0,-1};
        
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            
            int ncol=col+delcol[i];
            
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1' && !visit[nrow][ncol])
            {
                dfs(grid,nrow,ncol,visit);
            }
        }
    }
}
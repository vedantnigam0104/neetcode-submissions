class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;

        int n=grid[0].length;

        int maxarea=0;

        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                {
                    maxarea=Math.max(dfs(i,j,grid,vis),maxarea);
                }
            }
        }
        return maxarea;
    }
    int dfs(int r,int c,int[][] grid,boolean[][] vis)
    {
        int area=1;

        vis[r][c]=true;

        int[] dr={1,0,-1,0};

        int[] dc={0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr=dr[i]+r;

            int nc=dc[i]+c;

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1)
            {
                area+=dfs(nr,nc,grid,vis);
            }
        }
        return area;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
       int m=grid.length;

       int n=grid[0].length;

       Queue<int[]> pq=new LinkedList<>();

       for(int i=0;i<m;i++)
       {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    pq.add(new int[]{i,j});
                }
            }
       }

       while(!pq.isEmpty())
       {
            int[] curr=pq.poll();

            int r=curr[0];

            int c=curr[1];

            int[] dr={1,0,-1,0};

            int[] dc={0,1,0,-1};

            for(int i=0;i<4;i++)
            {
                int nr=r+dr[i];

                int nc=c+dc[i];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==2147483647)
                {
                    grid[nr][nc]=1 + grid[r][c];

                    pq.add(new int[]{nr,nc});
                }
            }
       }
       return; 
    }
}

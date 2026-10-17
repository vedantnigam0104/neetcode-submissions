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
                    pq.add(new int[]{i,j});
            }
        }

        int[] dr={0,1,0,-1};

        int[] dc={1,0,-1,0};

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();

            int r=curr[0];

            int c=curr[1];

            for(int i=0;i<4;i++)
            {
                int nr=dr[i]+r;

                int nc=dc[i]+c;

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==2147483647)
                {
                    grid[nr][nc]=grid[r][c]+1;

                    pq.add(new int[]{nr,nc});
                }
            }
        }
        return;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;

        int n=grid[0].length;

        int fresh=0;

        Queue<int[]> pq=new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    pq.add(new int[]{i,j});
                else
                    continue;        
            }
        }

        int time=0;

        int[] dr={1,0,-1,0};

        int[] dc={0,1,0,-1};

        while(!pq.isEmpty())
        {
            int size=pq.size();

            boolean rot=false;

            for(int k=0;k<size;k++)
            {
                int[] curr=pq.poll();

                int r=curr[0];

                int c=curr[1];

                for(int z=0;z<4;z++)
                {
                    int nr=r+dr[z];

                    int nc=c+dc[z];

                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;

                        fresh--;

                        pq.add(new int[]{nr,nc});

                        rot=true;
                    }
                }
            }
            if(rot)
                time++;
        }
        return fresh==0?time:-1;
    }
}

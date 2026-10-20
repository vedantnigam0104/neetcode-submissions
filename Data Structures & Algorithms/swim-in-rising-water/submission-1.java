class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        int n=grid.length;

        boolean[][] vis=new boolean[n][n];

        pq.add(new int[]{grid[0][0],0,0});

        vis[0][0]=true;

        int[] dr={1,0,-1,0};

        int[] dc={0,1,0,-1};

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();

            int time=curr[0];

            int r=curr[1];

            int c=curr[2];

            vis[r][c]=true;

            if(r==n-1 && c==n-1)
                return time;

            for(int i=0;i<4;i++)
            {
                int nr=dr[i]+r;

                int nc=dc[i]+c;

                if(nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc])
                {
                    int newtime=Math.max(time,grid[nr][nc]);

                    pq.add(new int[]{newtime,nr,nc});
                }
            }
        }
        return 0;
    }
}

public class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> pq=new LinkedList<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    pq.offer(new int[]{i,j});
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
                int nr=dr[i]+r;

                int nc=dc[i]+c;

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==Integer.MAX_VALUE)
                {
                    grid[nr][nc]=grid[r][c]+1;

                    pq.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
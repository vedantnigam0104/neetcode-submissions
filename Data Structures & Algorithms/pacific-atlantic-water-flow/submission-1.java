class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();

        List<Integer> li=new ArrayList<>();

        int m=heights.length;

        int n=heights[0].length;

        boolean[][] atlantic=new boolean[m][n];

        boolean[][] pacific=new boolean[m][n];

        for(int i=0;i<n;i++)
        {
            dfs(0,i,heights,pacific);

            dfs(m-1,i,heights,atlantic);
        }

        for(int j=0;j<m;j++)
        {
            dfs(j,0,heights,pacific);

            dfs(j,n-1,heights,atlantic);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(atlantic[i][j] && pacific[i][j])
                {
                   li.add(i);

                    li.add(j);

                    res.add(Arrays.asList(i,j));

                    li=new ArrayList<>();
                }
            }
        }
        return res;
    }
    void dfs(int r,int c,int[][] heights,boolean[][] vis)
    {
        vis[r][c]=true;

        int[] dr={1,0,-1,0};

        int[] dc={0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr=dr[i]+r;

            int nc=dc[i]+c;

            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc]>=heights[r][c] && !vis[nr][nc])
            {
                dfs(nr,nc,heights,vis);
            }
        }
    }
}

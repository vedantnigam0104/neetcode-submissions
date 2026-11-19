class Solution {
    public void solve(char[][] board) {
        int m=board.length;

        int n=board[0].length;

        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<n;i++)
        {
            help(0,i,board,vis);

            help(m-1,i,board,vis);
        }

        for(int j=0;j<m;j++)
        {
            help(j,0,board,vis);

            help(j,n-1,board,vis);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='S')
                    board[i][j]='O';

                else if(board[i][j]=='O')
                    board[i][j]='X';    
            }
        }
        return;
    }
    void help(int r,int c,char[][] board,boolean[][] vis)
    {
        if(board[r][c]!='O' || vis[r][c])
            return;
            
        vis[r][c]=true;

        board[r][c]='S';

        int[] dr={1,0,-1,0};

        int[] dc={0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr=r+dr[i];

            int nc=c+dc[i];

            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && !vis[nr][nc] && board[nr][nc]=='O')
            {
                help(nr,nc,board,vis);
            }
        }
        return;
    }
}

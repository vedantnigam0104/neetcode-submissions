class Solution {
    public boolean isValidSudoku(char[][] board) {
         Set<Character>[] rows=new HashSet[9];

        Set<Character>[] col=new HashSet[9];

        Set<Character>[] boxes=new HashSet[9];

        for(int i=0;i<9;i++)
        {
            rows[i]=new HashSet<>();

            col[i]=new HashSet<>();

            boxes[i]=new HashSet<>();
        }

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char num=board[i][j];

                if(num=='.')
                    continue;

                int boxno=(i/3)*3+(j/3);

                if(rows[i].contains(num) || col[j].contains(num) || boxes[boxno].contains(num))
                    return false;

                rows[i].add(num);

                col[j].add(num);

                boxes[boxno].add(num);         
            }
        }
        return true; 
    }
}

class Solution {
    void backtrack(char[][]board,int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 ||col>=m||board[row][col]!='O') return;
        board[row][col]='s';
        backtrack(board,row+1,col,n,m);
        backtrack(board,row-1,col,n,m);
        backtrack(board,row,col+1,n,m);
        backtrack(board,row,col-1,n,m);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                backtrack(board,i,0,n,m);
            }
            if(board[i][m-1]=='O'){   
                backtrack(board,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                backtrack(board,0,j,n,m);
            }
            if(board[n-1][j]=='O'){
                backtrack(board,n-1,j,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='s'){
                    board[i][j]='O';
                }
            }
        }
        
    }
}
//https://leetcode.com/problems/valid-sudoku/
class Solution {
    int row[];
    int col[];
    int mat[][];
    public boolean isValidSudoku(char[][] board) {
        row=new int[9];
        col=new int[9];
        mat=new int[3][3];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //2d to 1d
                if(board[i][j]=='.'){
                    
                }else{
                    int mask=1<<(board[i][j]-'0');
                    if((row[i]&mask)==0 &&(col[j]&mask)==0 &&(mat[i/3][j/3]&mask)==0){
                      row[i]^=mask;
                        col[j]^=mask;
                        mat[i/3][j/3]^=mask;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
        

    }
  
    
  
}

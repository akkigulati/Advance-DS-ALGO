import java.util.*;
class bitMasking{
    public static void main(String argv[]) {
        // sudoku();
        System.out.println(NQueenCombination_usingBits(0,4,"",4));
    }
    static int[] rows;
    static int[] cols;
    static int[][] mat;

    public static int sudokuSolver_BitMasking(int[][] board,int vidx,ArrayList<Integer> locOfZeros){
        if(vidx == locOfZeros.size()){
            // display2D(board);
            return 1;
        }

        int twoDloc = locOfZeros.get(vidx);
        int r = twoDloc / 9;
        int c = twoDloc % 9;
        
        int count=0;
        
        for(int num = 1 ; num <= 9; num++){    
            int mask= (1 << num);
            if((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r/3][c/3] & mask) == 0){
                
                rows[r] ^=mask;
                cols[c] ^=mask;
                mat[r/3][c/3] ^=mask;
                board[r][c] = num;

                count += sudokuSolver_BitMasking(board,vidx + 1,locOfZeros);

                rows[r] ^=mask;
                cols[c] ^=mask;
                mat[r/3][c/3] ^=mask;
                board[r][c] = 0;
            }
        }
        return count;
    }


    public static void sudoku(){
        int[][] board = {{3, 0, 0, 6, 0, 0, 0, 9, 2},  
                         {5, 2, 0, 0, 0, 0, 4, 0, 8},  
                         {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                         {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
        
        rows = new int[9];
        cols = new int[9];
        mat = new int[3][3];

        ArrayList<Integer> locOfZeros=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    locOfZeros.add( i*9 + j );
                }else{
                    int val = board[i][j];
                    int mask= (1 << val);
                    rows[i] ^=mask;
                    cols[j] ^=mask;
                    mat[i/3][j/3] ^=mask;
                }
            }
        }

        System.out.println(sudokuSolver_BitMasking(board,0,locOfZeros));
    }
    static int rowsBQ=0;
    static int colsBQ=0;
    static int diagBQ=0;
    static int AdiagBQ=0;

    public static int NQueenCombination_usingBits(int idx,int tnq,String ans,int m){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }

        int count=0;
        int n=m;
        for(int i=idx;i<n*m;i++){
            int r = i / m;
            int c = i % m; 
            int maskr= (1 << r);
            int maskc=(1<<c);
            int maskd=(1<<(r+c));
            int maskad=(1<<(r-c+m));
            if((rowsBQ & maskr)==0 && (colsBQ & maskc)==0 && (diagBQ &maskd)==0 && (AdiagBQ & maskad)==0){
                rowsBQ ^=(maskr);
                colsBQ ^=(maskc);
                diagBQ ^=(maskd);
                AdiagBQ ^=(maskad);
                
                count+=NQueenCombination_usingBits(i+1,tnq-1,ans + "(" + r + ", " + c + ") ",m);
                
                rowsBQ ^=(maskr);
                colsBQ ^=(maskc);
                diagBQ ^=(maskd);
                AdiagBQ ^=(maskad);
            }
        }

        return count;
    }
}
//https://leetcode.com/problems/path-with-maximum-gold/submissions/
class Solution {
    public int getMaximumGold(int[][] grid) {
        int gold=Integer.MIN_VALUE;
        int moves[][]={{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                gold=Math.max(gold,print(grid,i,j,moves));
            }
        }
        return gold;
    }
    public static int print(int grid[][],int sr,int sc,int moves[][]){
        if(sr<0||sc<0||sr>grid.length-1||sc>grid[0].length-1||grid[sr][sc]<=0){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        int val=grid[sr][sc];
        grid[sr][sc]=-1*grid[sr][sc];
        for(int i=0;i<moves.length;i++){
            ans=Math.max(ans,val+print(grid,sr+moves[i][0],sc+moves[i][1],moves));
        }
        grid[sr][sc]=-1*grid[sr][sc];
        return ans;
    } 
}

/*https://leetcode.com/problems/unique-paths-iii/
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Note:

1 <= grid.length * grid[0].length <= 20
*/

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroes=0;
        int n=grid.length;
        int m=grid[0].length;
        int sr=0,sc=0,dr=0,dc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                zeroes+=(grid[i][j]==0)?1:0;
                if(grid[i][j]==1){
                    sr=i;
                    sc=j;
                }
                if(grid[i][j]==2){
                    dr=i;
                    dc=j;
                }
            }
        }
        int moves[][]={{-1,0},{1,0},{0,1},{0,-1}};
        return print(grid,sr,sc,dr,dc,zeroes,1,moves);
    }
    public static int print(int grid[][],int sr,int sc,int dr,int dc,int zeroes,int t,int moves[][]){
        if(sr<0||sc<0||sr>grid.length-1||sc>grid[0].length-1||grid[sr][sc]==-1){
            return 0;
        }
        if(sr==dr&&sc==dc&&t==zeroes+2){
            System.out.println(t);
            return 1;
        }
        int count=0;
        if(t!=0)
            grid[sr][sc]=-1;
        for(int i=0;i<moves.length;i++){
            count+=print(grid,sr+moves[i][0],sc+moves[i][1],dr,dc,zeroes,t+1,moves);
        }
        if(t!=0)
            grid[sr][sc]=0;
        
        return count;
        
    }
}

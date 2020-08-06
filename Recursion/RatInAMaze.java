class GfG {
    public static ArrayList<String> printPath(int[][] m, int n) {
       ArrayList<String> ans=new ArrayList<>();
       
        int moves[][]={
            {1,0},{0,-1},{0,1},{-1,0}
        };
        String Dir[]={
            "D","L","R","U"
        };
        
        maze(m,n-1,0,0,new boolean[n][n],Dir,moves,"",ans);
        // if(ans.size()==0){
        //     ans.add("-1");
        // }
        return ans;
    }
    public static void maze(int m[][],int n,int sr,int sc,boolean[][] vis,String Dir[],int moves[][],String asf,ArrayList<String> ans){
        if(sr<0||sc<0||sr>n||sc>n||vis[sr][sc]||m[sr][sc]==0){
            return;
        }
        if(sr==n&&sc==n){
            ans.add(asf);
            return;
        }
        vis[sr][sc]=true;
            // System.out.println(sr+sc);
        for(int i=0;i<moves.length;i++){
            maze(m,n,sr+moves[i][0],sc+moves[i][1],vis,Dir,moves,asf+Dir[i],ans);
        }
        vis[sr][sc]=false;
        return;
    }
}
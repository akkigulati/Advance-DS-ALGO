class L001{

    public static int MazePath(int sr,int sc,int dr,int dc,String asf){
        if(sr>dr||sc>dc){
            return 0;
        }
        if(sr==dr&&sc==dc){
            System.out.println(asf);
            return 1;
        }
        return MazePath(sr+1,sc,dr,dc,asf+"v")+MazePath(sr,sc+1,dr,dc,asf+"h")+MazePath(sr+1,sc+1,dr,dc,asf+"d");
    }
    public static int MazePathJumps(int sr,int sc,int dr,int dc,String asf){
        if(sr>dr||sc>dc){
            return 0;
        }
        if(sr==dr&&sc==dc){
            System.out.println(asf);
            return 1;
        }
        int count=0;
        for(int i=1;sr+i<=dr;i++){
            count+=MazePathJumps(sr+i,sc,dr,dc,asf+"v"+i);
        }
        for(int i=1;sc+i<=dc;i++){
           count+= MazePathJumps(sr,sc+i,dr,dc,asf+"h"+i);
        }
        for(int i=1;sr+i<=dr&&sc+i<=dc;i++){
           count+= MazePathJumps(sr+i,sc+i,dr,dc,asf+"d"+i);
        }
        return count;
    }
    public static int mazePathHV(int sr,int sc,int dr,int dc,String asf,int moves[][],boolean visited[][],String Dir[]){
        if(sr<0||sc<0||sr>dr||sc>dc||visited[sr][sc]){
            return 0;
        }
        if(sr==dr&&sc==dc){
            System.out.println(asf);
            return 1;
        }
        visited[sr][sc]=true;
        int count=0;
        for(int i=0;i<moves.length;i++){
            
            count+=mazePathHV(sr+moves[i][0],sc+moves[i][1],dr,dc,asf+Dir[i],moves,visited,Dir);
            
        }
        visited[sr][sc]=false;
        return count;

    }
    public static int mazePathHVMulti(int sr,int sc,int dr,int dc,String asf,int moves[][],boolean visited[][],String Dir[]){
        if(sr<0||sc<0||sr>dr||sc>dc||visited[sr][sc]){
            return 0;
        }
        if(sr==dr&&sc==dc){
            System.out.println(asf);
            return 1;
        }
        visited[sr][sc]=true;
        int count=0;
        for(int jumps=1;jumps<=Math.max(dr,dc);jumps++)
        for(int i=0;i<moves.length;i++){
            
            count+=mazePathHVMulti(sr+moves[i][0]*jumps,sc+moves[i][1]*jumps,dr,dc,asf+Dir[i]+jumps,moves,visited,Dir);
            
        }
        visited[sr][sc]=false;
        return count;

    }
    public static void maze(){
        int moves[][]={
            {-1,0},{0,1},{1,0},{0,-1}            
        };
        //Directions in which I can travel.
        String Dir[]={
            "N","E","S","W"
        };
        
        System.out.println(mazePathHVMulti(0,0,2,2,"",moves,new boolean[4][4],Dir));
    }
    public static void main(String[] argv){
        maze();
    }
}